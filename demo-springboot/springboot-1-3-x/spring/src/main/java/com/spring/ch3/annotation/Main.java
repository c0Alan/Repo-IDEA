package com.spring.ch3.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 组合注解 实例
 *
 * @author liuxilin
 * @date 2018/6/10 18:48
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        DemoService demoService = context.getBean(DemoService.class);

        demoService.outputResult();

        context.close();
    }

}
