package com.spring.ch2.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
/**
 * 事件监听实例
 * 
 * @author liuxilin
 * @date 2018/6/10 18:30
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(EventConfig.class);

        DemoPublisher demoPublisher = context.getBean(DemoPublisher.class);

        demoPublisher.publish("hello application event");

        context.close();
    }
}
