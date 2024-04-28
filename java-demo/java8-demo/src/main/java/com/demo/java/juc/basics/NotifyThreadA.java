package com.demo.java.juc.basics;

class NotifyThreadA extends Thread {

    public NotifyThreadA(String name) {
        super(name);
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " call notify()");
            // 唤醒当前的wait线程
            notify();
        }
    }
}