package com.rabbitmq.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
    @Autowired
    AmqpTemplate amqpTemplate;

    public void sendHello(){
        String msg = "Msg from sender: hello";
        System.out.println("sender: " + msg);
        amqpTemplate.convertAndSend("hello", msg);
    }
}
