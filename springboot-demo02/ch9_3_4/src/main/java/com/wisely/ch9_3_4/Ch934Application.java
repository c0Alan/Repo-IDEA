package com.springboot.ch9_3_4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;

/**
 * Spring Boot 为我们提供了CommandLineRunner 接口，用于程序启动后执行的代码，
 * 通过重写其run 方法执行。
 */
@SpringBootApplication
public class Ch934Application implements CommandLineRunner { //1

    /** 注入Spring Boot 为我们配置好的JmsTemplate 的Bean */
    @Autowired
    JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Ch934Application.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        // 通过JmsTemplate 的send 方法向my-destination 目的地发送Msg 的消息，
        // 这里也等于在消息代理上定义了一个目的地叫my-destination
        jmsTemplate.send("my-destination", new Msg()); //3

    }
}
