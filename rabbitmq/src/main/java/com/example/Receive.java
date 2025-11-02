package com.example;

import com.rabbitmq.client.*;

public class Receive {
    private static final String QUEUE_NAME = "hello";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("admin");
        factory.setPassword("admin123");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages...");

        DeliverCallback callback = (tag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received: " + message);
        };

        channel.basicConsume(QUEUE_NAME, true, callback, consumerTag -> {});
    }
}