package com.spring.ch2.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 环境配置实例
 * 
 * @author liuxilin
 * @date 2018/6/10 18:36
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();

        context.getEnvironment().setActiveProfiles("dev"); // 设置有效环境
        context.register(ProfileConfig.class);// 后置注册 Bean 配置类，不然会报Bean 未定义的错误
        context.refresh(); // 刷新容器

        DemoBean demoBean = context.getBean(DemoBean.class);
        System.out.println(demoBean.getContent());
        context.close();
    }
}
