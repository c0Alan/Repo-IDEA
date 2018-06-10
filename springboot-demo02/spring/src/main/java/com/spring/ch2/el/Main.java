package com.spring.ch2.el;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 属性值注入实例
 * 
 * @author liuxilin
 * @date 2018/6/10 18:24
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ElConfig.class);

        ElConfig resourceService = context.getBean(ElConfig.class);
        resourceService.outputResource();
        context.close();
    }

}
