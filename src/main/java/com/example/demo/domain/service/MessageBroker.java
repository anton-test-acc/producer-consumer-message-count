package com.example.demo.domain.service;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

@Service
public class MessageBroker {

    private final BlockingQueue<Message<String>> queue = new LinkedBlockingQueue<>();

    public void send(Message<String> message) throws InterruptedException {
        queue.put(message);
    }

    public Message<String> take() throws InterruptedException {
        return queue.poll(3, TimeUnit.SECONDS);
    }
}
