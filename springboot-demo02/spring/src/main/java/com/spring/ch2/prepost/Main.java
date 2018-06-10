package com.spring.ch2.prepost;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * bean 的初始化和销毁实例
 * 
 * @author liuxilin
 * @date 2018/6/10 18:35
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(PrePostConfig.class);

        BeanWayService beanWayService = context.getBean(BeanWayService.class);
        JSR250WayService jsr250WayService = context.getBean(JSR250WayService.class);

        context.close();
    }

}
