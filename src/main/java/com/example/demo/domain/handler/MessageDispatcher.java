package com.example.demo.domain.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;

@Service
public class MessageDispatcher {

    private final Set<MessageHandler> handlers;

    @Autowired
    public MessageDispatcher(Set<MessageHandler> handlers) {
        this.handlers = Collections.unmodifiableSet(handlers);
    }

    public void handle(Message<String> message) throws IOException {
        for (MessageHandler handler : handlers) {
            handler.handleMessage(message);
        }
    }
}
