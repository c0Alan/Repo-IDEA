package com.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 接收者测试, 接收hello信息
 *
 * @author liuxl
 * @date 2018/4/14 17:14
 */
@Component
@RabbitListener(queues = "hello")
public class Receiver {

    @RabbitHandler
    public void receiveHello(String hello){
        System.out.println("Receiver: " + hello);
    }
}
