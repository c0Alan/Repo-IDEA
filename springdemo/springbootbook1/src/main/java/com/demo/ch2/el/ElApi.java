package com.demo.ch2.el;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ElApi {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ElConfig.class);
        ElConfig resourceService = (ElConfig) context.getBean("elConfig");
        resourceService.outputResource();
    }
}
