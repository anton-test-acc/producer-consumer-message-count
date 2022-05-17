package com.example.demo.domain.handler;

import org.springframework.messaging.Message;

import java.io.IOException;

public interface MessageHandler {

    void handleMessage(Message<String> message) throws IOException;
}
