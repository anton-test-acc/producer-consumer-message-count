package com.example.demo.domain.handler;

import com.example.demo.domain.entity.MessageType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import static com.example.demo.domain.entity.MessageType.SHUTDOWN;

@Service
public class MetricsHandler implements MessageHandler {

    private static Logger logger = LoggerFactory.getLogger(MetricsHandler.class);

    private AtomicLong count = new AtomicLong();
    private Map<String, AtomicLong> metrics = new ConcurrentHashMap<>();

    @Override
    public void handleMessage(Message<String> message) {
        if (SHUTDOWN == message.getHeaders().get("type", MessageType.class)) {
            logger.info("Total messages: {}", count);
            logger.info("{}", metrics);
        } else {
            count.incrementAndGet();
            String deviceID = message.getHeaders().get("deviceId", String.class);
            metrics.computeIfAbsent(deviceID, k -> new AtomicLong()).getAndIncrement();
        }
    }

    public AtomicLong getCount() {
        return count;
    }

    public Map<String, AtomicLong> getMetrics() {
        return metrics;
    }
}
