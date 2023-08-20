package com.jd.java8.juc.basic.wait;

public class MyThread01 extends Thread {

    public MyThread01(String name) {
        super(name);
    }

    public void run() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " call notify()");
            // 唤醒当前的wait线程, 调用notify()唤醒“当前对象上的等待线程”
            notify();
        }
    }
}