package com.spring.ch2.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 监听器
 * 
 * @author liuxilin
 * @date 2018/6/10 18:30
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

    public void onApplicationEvent(DemoEvent event) {

        String msg = event.getMsg();

        System.out.println("我(bean-demoListener)接受到了bean-demoPublisher发布的消息:"
                + msg);

    }

}
