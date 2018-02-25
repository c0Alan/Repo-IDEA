package com.demo.ch2.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EventApi {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);
        DemoPublisher publisher = context.getBean(DemoPublisher.class);
        publisher.publish("event published!");
        context.close();
    }
}
