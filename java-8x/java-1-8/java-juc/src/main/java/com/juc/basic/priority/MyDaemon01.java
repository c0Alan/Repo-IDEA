package com.juc.basic.priority;

public class MyDaemon01 extends Thread {
    public MyDaemon01(String name) {
        super(name);
    }

    public void run() {
        try {
            for (int i = 0; i < 10000; i++) {
                Thread.sleep(1);
                System.out.println(this.getName() + "(isDaemon=" + this.isDaemon() + ")" + ", loop " + i);
            }
        } catch (InterruptedException e) {
        }
    }
}