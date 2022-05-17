package com.example.demo.domain.service;

import com.example.demo.domain.entity.MessageType;
import com.example.demo.domain.handler.MessageDispatcher;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class Consumer {

    private final MessageDispatcher dispatcher;
    private final MessageBroker broker;

    public Consumer(MessageDispatcher dispatcher, MessageBroker broker) {
        this.dispatcher = dispatcher;
        this.broker = broker;
    }

    public void start() {
        while (true) {
            try {
                Message<String> message = this.broker.take();

                // Shutdown imitation
                if (message == null) {
                    Map<String, Object> headers = new HashMap<>();
                    headers.put("type", MessageType.SHUTDOWN);
                    this.dispatcher.handle(new GenericMessage<>("", headers));
                    break;
                }

                // Can be a reactor with thread pool
                this.dispatcher.handle(message);
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
