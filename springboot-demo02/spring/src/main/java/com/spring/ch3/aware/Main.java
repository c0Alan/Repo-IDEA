package com.spring.ch3.aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Aware (意识) 实例
 * Spring Aware 的目的是为了让Bean 获得Spring 容器的服务。因为ApplicationContext 接
 * 口集成了MessageSource 接口、ApplicationEventPublisher 接口和ResourceLoader 接口，
 * 所以Bean 继承ApplicationContextAware 可以获得Spring 容器的所有服务，
 * 但原则上我们还是用到什么接口，就实现什么接口。
 *
 * @author liuxilin
 * @date 2018/6/10 19:03
 */
public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AwareConfig.class);

        AwareService awareService = context.getBean(AwareService.class);
        awareService.outputResult();

        context.close();
    }
}
