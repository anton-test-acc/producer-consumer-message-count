package com.example.demo;

import com.example.demo.domain.entity.DiskPayload;
import com.example.demo.domain.entity.GatewayPayload;
import com.example.demo.domain.entity.MessageType;
import com.example.demo.domain.entity.PowerSourcePayload;
import com.example.demo.domain.service.Consumer;
import com.example.demo.domain.service.MessageBroker;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static com.example.demo.domain.entity.MessageType.DISK;
import static com.example.demo.domain.entity.MessageType.GATEWAY;
import static com.example.demo.domain.entity.MessageType.POWER_SOURCE;

@SpringBootApplication
public class DeviceMonitorApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DeviceMonitorApplication.class, args);
		MessageBroker broker = context.getBean(MessageBroker.class);
		Consumer consumer = context.getBean(Consumer.class);

		final ExecutorService pool = Executors.newCachedThreadPool();
		final ObjectMapper mapper = new ObjectMapper();

		pool.submit(() -> {
			IntStream.range(0, 10).forEachOrdered(i -> {
				try {
					broker.send(createMessage(mapper, DISK, "D1", new DiskPayload(ThreadLocalRandom.current().nextDouble(),
							ThreadLocalRandom.current().nextDouble(), ThreadLocalRandom.current().nextDouble())));
				} catch (IOException | InterruptedException e) {
					e.printStackTrace();
				}
			});
		});

		pool.submit(() -> {
			IntStream.range(0, 15).forEachOrdered(i -> {
				try {
					broker.send(createMessage(mapper, DISK, "D2", new DiskPayload(ThreadLocalRandom.current().nextDouble(),
							ThreadLocalRandom.current().nextDouble(), ThreadLocalRandom.current().nextDouble())));
				} catch (IOException | InterruptedException e) {
					e.printStackTrace();
				}
			});
		});

		pool.submit(() -> {
			IntStream.range(0, 25).forEachOrdered(i -> {
				try {
					broker.send(createMessage(mapper, POWER_SOURCE, "P1", new PowerSourcePayload(ThreadLocalRandom.current().nextDouble(),
							ThreadLocalRandom.current().nextDouble())));
				} catch (IOException | InterruptedException e) {
					e.printStackTrace();
				}
			});
		});

		pool.submit(() -> {
			IntStream.range(0, 10).forEachOrdered(i -> {
				try {
					broker.send(createMessage(mapper, GATEWAY, "G1", new GatewayPayload(ThreadLocalRandom.current().nextDouble(),
							ThreadLocalRandom.current().nextDouble(), ThreadLocalRandom.current().nextInt(0, 100))));
				} catch (IOException | InterruptedException e) {
					e.printStackTrace();
				}
			});
		});

		consumer.start();
		pool.shutdown();
	}


	public static <T> Message<String> createMessage(ObjectMapper mapper, MessageType type, String deviceId, T payload) throws IOException {
		Map<String, Object> headers = new HashMap<>();
		headers.put("type", type);
		headers.put("deviceId", deviceId);
		return new GenericMessage<>(mapper.writeValueAsString(payload), headers);
	}

}
