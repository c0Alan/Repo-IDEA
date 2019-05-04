package com.spring.ch1.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 切面编程实例
 * 
 * @author liuxilin
 * @date 2018/6/10 18:31
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AopConfig.class); //1
        DemoAnnotationService demoAnnotationService = context.getBean(DemoAnnotationService.class);
        DemoMethodService demoMethodService = context.getBean(DemoMethodService.class);
        demoAnnotationService.add();
        demoMethodService.add();
        context.close();
    }

}
