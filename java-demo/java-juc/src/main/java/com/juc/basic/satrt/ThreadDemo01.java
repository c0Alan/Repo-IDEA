package com.juc.basic.satrt;

/**
 * 创建线程的方式 1: 直接创建 Thread
 * 
 * @author liuxilin
 * @date 2018/5/19 22:42
 */
public class ThreadDemo01 {
    public static void main(String[] args) {
        // 启动3个线程t1,t2,t3；每个线程各卖10张票！
        MyThread01 t1 = new MyThread01();
        MyThread01 t2 = new MyThread01();
        MyThread01 t3 = new MyThread01();
        t1.start();
        t2.start();
        t3.start();
    }
}

