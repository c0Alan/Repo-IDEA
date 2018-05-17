package com.web.listener.demo;

/**
 * 设计事件类，用来封装事件源
 *
 * @author liuxilin
 * @date 2018/5/17 22:32
 */
public class Event {

    /**
     * 事件源(Person就是事件源)
     */
    private Person source;

    public Event() {

    }

    public Event(Person source) {
        this.source = source;
    }

    public Person getSource() {
        return source;
    }

    public void setSource(Person source) {
        this.source = source;
    }
}