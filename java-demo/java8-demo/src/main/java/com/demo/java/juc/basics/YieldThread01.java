package com.demo.java.juc.basics;

class YieldThread01 extends Thread {
    public YieldThread01(String name) {
        super(name);
    }

    public synchronized void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s [%d]:%d\n", this.getName(), this.getPriority(), i);
            // i整除4时，调用yield
            if (i % 4 == 0)
                Thread.yield();
        }
    }
}