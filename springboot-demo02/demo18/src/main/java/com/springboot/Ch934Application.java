package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;

/**
 * 异步消息
 * 异步消息主要有两种形式的目的地:队列 (queue) 和主题 (topic) 。
 * 队列用于点对点式 (point-to-point) 的消息通信:
 * 主题用于发布/订阅式 (publish/subscribe) 的消息通信。
 * <p>
 * JMS(Java Message Service)即 Java 消息服务，是基于JVM消息代理的规范
 * ActiveMQ 、HornetQ 是一个JMS 消息代理的实现。
 * <p>
 * ActiveMQ
 * Spring Boot 为我们提供了 CommandLineRunner 接口，用于程序启动后执行的代码，
 * 通过重写其run 方法执行。
 */
@SpringBootApplication
public class Ch934Application implements CommandLineRunner {

    /**
     * 注入Spring Boot 为我们配置好的JmsTemplate 的Bean
     */
    @Autowired
    JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Ch934Application.class, args);

    }

    /**
     * 通过JmsTemplate 的send 方法向my-destination 目的地发送Msg 的消息，
     * 这里也等于在消息代理上定义了一个目的地叫 my-destination
     *
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {

        int i = 0;
        for (; ; ) {
            Thread.sleep(1000);
            String msg = "消息" + i;
            jmsTemplate.send("my-destination", new Msg(msg));
            i++;
        }

    }
}
