package com.jd.java8.juc.basic.yield;

public class MyThread01 extends Thread {
    private Object obj;

    public MyThread01(String name, Object obj) {
        super(name);
        this.obj = obj;
    }

    public void run() {
        synchronized (obj) {
            for (int i = 0; i <= 900; i++) {
                System.out.printf("%s [%d]:%d\n", this.getName(), this.getPriority(), i);
                // i整除3时，调用yield
                if (i % 3 == 0) {
                    Thread.yield();
                }
            }
        }

    }
} 