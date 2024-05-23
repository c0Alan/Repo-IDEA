package com.demo.java.web.listener.demo;

/**
 * 事件源
 * 设计一个Person类作为事件源，这个类的对象的行为(比如吃饭、跑步)可以被其他的对象监听
 *
 * @author liuxilin
 * @date 2018/5/17 22:30
 */
public class Person {

    // 在Person类中定义一个PersonListener变量来记住传递进来的监听器
    private PersonListener listener;

    /**
     * 设计Person的行为：吃
     */
    public void eat() {
        if (listener != null) {
            /**
             * 调用监听器的doeat方法监听Person类对象eat(吃)这个动作，将事件对象Event传递给doeat方法，
             * 事件对象封装了事件源，new Event(this)中的this代表的就是事件源
             */
            listener.doeat(new Event(this));
        }
    }

    /**
     * 设计Person的行为：跑
     */
    public void run() {
        if (listener != null) {
            /**
             * 调用监听器的dorun方法监听Person类对象run(跑)这个动作，将事件对象Event传递给doeat方法，
             * 事件对象封装了事件源，new Event(this)中的this代表的就是事件源
             */
            listener.dorun(new Event(this));
        }
    }

    /**
     * 这个方法是用来注册对Person类对象的行为进行监听的监听器
     * @param listener
     */
    public void registerListener(PersonListener listener) {
        this.listener = listener;
    }
}