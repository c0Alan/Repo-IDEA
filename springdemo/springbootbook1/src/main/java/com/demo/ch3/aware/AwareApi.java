package com.demo.ch3.aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AwareApi {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AwareConfig.class);
        AwareService service = context.getBean(AwareService.class);
        service.outPut();
        context.close();
    }
}
