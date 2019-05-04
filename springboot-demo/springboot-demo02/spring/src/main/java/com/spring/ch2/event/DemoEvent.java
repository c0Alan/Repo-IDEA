package com.spring.ch2.event;

import org.springframework.context.ApplicationEvent;

/**
 * 事件
 * 
 * @author liuxilin
 * @date 2018/6/10 18:28
 */
public class DemoEvent extends ApplicationEvent {
    private static final long serialVersionUID = 1L;
    private String msg;

    public DemoEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
        System.out.println(msg);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
