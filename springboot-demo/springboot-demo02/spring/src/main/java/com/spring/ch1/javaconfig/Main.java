package com.spring.ch1.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 通过自定义配置类注入bean
 * 
 * @author liuxilin
 * @date 2018/6/10 17:29
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(JavaConfig.class);

        UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);

        System.out.println(useFunctionService.SayHello("java config"));

        context.close();

    }
}
