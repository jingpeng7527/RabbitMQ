package com.example;

import com.rabbitmq.client.*;

public class Send {
    private static final String QUEUE_NAME = "hello";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("admin");
        factory.setPassword("admin123");

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "Hello from VS Code!";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent: " + message);
        }
    }
}
