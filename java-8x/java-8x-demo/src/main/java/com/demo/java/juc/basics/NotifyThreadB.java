package com.demo.java.juc.basics;

import lombok.SneakyThrows;

class NotifyThreadB extends Thread {

    public NotifyThreadB(String name) {
        super(name);
    }

    @SneakyThrows
    public void run() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " run ");
            // 死循环，不断运行。
            while (true) {
                sleep(2000);
                System.out.println(Thread.currentThread().getName() + " run ");
            }
        }
    }
}