package com.demo.ch1.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigApi {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        ConfigService configService = (ConfigService) context.getBean("configService");
        ConfigDao configDao = (ConfigDao) context.getBean("configDaoaaa");
        configService.sayHello();
        System.out.println(configDao);
        System.out.println(configService.getConfigDao());
    }
}
