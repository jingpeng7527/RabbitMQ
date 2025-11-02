package com.example.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    @RabbitListener(queues = RabbitConfig.QUEUE_NAME, concurrency = "10-50")
    public void receive(String message) {
        System.out.println("Received: " + message);
        // You can handle user-specific message logic here
    }
}