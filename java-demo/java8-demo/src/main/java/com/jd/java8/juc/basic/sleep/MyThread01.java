package com.jd.java8.juc.basic.sleep;

public class MyThread01 extends Thread {
    public MyThread01(String name) {
        super(name);
    }

    public synchronized void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.printf("%s: %d\n", this.getName(), i);
                // i能被4整除时，休眠100毫秒
                if (i % 4 == 0)
                    Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
} 