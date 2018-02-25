package com.demo;

import com.demo.config.ApiConfig;
import com.demo.service.HelloService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloApi {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApiConfig.class);
        HelloService helloService = (HelloService) context.getBean("helloService");
        helloService.sayHello();
        context.close();
    }
}
