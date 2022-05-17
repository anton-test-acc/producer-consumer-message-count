package com.example.demo.handler;

import com.example.demo.domain.entity.MessageType;
import com.example.demo.domain.handler.MetricsHandler;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.example.demo.domain.entity.MessageType.DISK;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MetricsHandlerTest {

    private MetricsHandler handler;
    private static ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    public void before() {
        handler = new MetricsHandler();
    }

    @Test
    public void shouldCount() {
        handler.handleMessage(createMessage(DISK, "id1", "Some payload"));
        handler.handleMessage(createMessage(DISK, "id2", "Some payload"));
        handler.handleMessage(createMessage(DISK, "id1", "Some payload"));

        assertEquals(3, handler.getCount().get());
        assertEquals(2, handler.getMetrics().get("id1").get());
        assertEquals(1, handler.getMetrics().get("id2").get());
    }

    private static <T> Message<String> createMessage(MessageType type, String deviceId, T payload) {
        try {
            Map<String, Object> headers = new HashMap<>();
            headers.put("type", type);
            headers.put("deviceId", deviceId);
            return new GenericMessage<>(mapper.writeValueAsString(payload), headers);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}