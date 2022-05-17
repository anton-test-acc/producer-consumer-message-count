package com.example.demo.domain.handler;

import com.example.demo.domain.entity.MessageType;
import com.example.demo.domain.entity.PowerSourcePayload;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static com.example.demo.domain.entity.MessageType.POWER_SOURCE;

@Service
public class PowerSourceMessageHandler implements MessageHandler {

    private static Logger logger = LoggerFactory.getLogger(PowerSourceMessageHandler.class);

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void handleMessage(Message<String> message) throws IOException {
        if (message.getHeaders().containsKey("type") && POWER_SOURCE == message.getHeaders().get("type", MessageType.class)) {
            logger.info(mapper.readValue(message.getPayload(), PowerSourcePayload.class).toString());
        }
    }
}
