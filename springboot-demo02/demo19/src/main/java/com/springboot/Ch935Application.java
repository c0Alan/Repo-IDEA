package com.springboot;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * rabbitmq
 * 点对点式 (point-to-point) 的消息通信
 *
 * AMQP (Advanced Message Queuing Protocol) 也是一个消息代理的规范，但它不仅兼容JMS ，
 * 还支持跨语言和平台。AMQP 的主要实现有RabbitMQ
 * 
 * @author liuxilin
 * @date 2018/6/15 20:43
 */
@SpringBootApplication
public class Ch935Application implements CommandLineRunner {
    // Spring Boot 为我们自动配置好的RabbitTemplate
    @Autowired
    RabbitTemplate rabbitTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Ch935Application.class, args);
    }

    /**
     * 定义目的地即队列，队列名称为my-queue
     * @return
     */
    @Bean
    public Queue wiselyQueue() {
        return new Queue("my-queue");
    }

    /**
     * 通过RabbitTemplate 的convertAndSend 方法向队列my-queue 发送消息。
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        int i = 0;
        for(;;){
            Thread.sleep(1000);
            rabbitTemplate.convertAndSend("my-queue", "来自RabbitMQ的问候" +i);
            i++;
        }
    }
}
