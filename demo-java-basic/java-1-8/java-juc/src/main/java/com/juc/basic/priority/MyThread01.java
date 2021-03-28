package com.juc.basic.priority;

public class MyThread01 extends Thread {
    public MyThread01(String name) {
        super(name);
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()
                    + "(" + Thread.currentThread().getPriority() + ")"
                    + ", loop " + i);
        }
    }
}