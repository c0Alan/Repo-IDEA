package com.spring.ch1.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 依赖注入实例
 * 
 * @author liuxilin
 * @date 2018/6/10 18:31
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DiConfig.class); //1

        UseFunctionService useFunctionService = context.getBean(UseFunctionService.class); //2

        System.out.println(useFunctionService.SayHello("world"));

        context.close();
    }
}
