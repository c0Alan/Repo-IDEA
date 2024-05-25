package com.demo.java.juc.basics;

class DaemonThread01 extends Thread {
    public DaemonThread01(String name) {
        super(name);
    }

    @Override
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