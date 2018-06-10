package com.spring.ch3.conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 条件注解实例
 * 根据不同的操作系统注入不同的bean
 *
 * @author liuxilin
 * @date 2018/6/10 20:43
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ConditionConifg.class);

        ListService listService = context.getBean(ListService.class);


        System.out.println(context.getEnvironment().getProperty("os.name")
                + "系统下的列表命令为: "
                + listService.showListCmd());

        context.close();
    }
}
