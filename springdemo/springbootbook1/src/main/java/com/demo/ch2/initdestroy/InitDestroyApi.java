package com.demo.ch2.initdestroy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InitDestroyApi {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(InitDestroyConfig.class);
        context.close();
    }
}
