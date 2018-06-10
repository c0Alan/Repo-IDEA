package com.spring.ch2.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 发布者
 * 
 * @author liuxilin
 * @date 2018/6/10 18:28
 */
@Component
public class DemoPublisher {
    @Autowired
    ApplicationContext applicationContext;

    /**
     * 发布事件
     * @param msg
     */
    public void publish(String msg) {
        applicationContext.publishEvent(new DemoEvent(this, msg));
    }

}
