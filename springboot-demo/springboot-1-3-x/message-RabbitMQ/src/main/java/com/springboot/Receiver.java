package com.springboot;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @RabbitListener(queues = "my-queue")
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
    }

    @RabbitListener(queues = "my-queue")
    public void receiveMessage2(String message) {
        System.out.println("Received2 <" + message + ">");
    }

}
