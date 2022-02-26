package com.demo.springcloud.java8.juc.basic.synchronize;

/**
 * 简单的 Synchronize 例子
 * 
 * @author liuxilin
 * @date 2018/5/20 9:20
 */
public class SynchronizeDemo02 {

    /**
     * 这个例子不会阻塞
     * @param args
     */
    public static void main(String[] args) {
        MyThread01 t1 = new MyThread01("t1");  // 新建“线程t1”
        MyThread01 t2 = new MyThread01("t2");  // 新建“线程t2”
        t1.start();                          // 启动“线程t1”
        t2.start();                          // 启动“线程t2” 
    }
}