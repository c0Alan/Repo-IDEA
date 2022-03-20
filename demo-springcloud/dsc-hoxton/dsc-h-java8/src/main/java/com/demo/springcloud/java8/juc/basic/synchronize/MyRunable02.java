package com.demo.springcloud.java8.juc.basic.synchronize;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyRunable02 implements Runnable {
    private int cnt = 300;

    @Override
    public void run() {
        synchronized (this) {
            try {
                log.info(Thread.currentThread().getName() + ": 剩余线程数" + cnt);
                Thread.sleep(5000);
                cnt--;
            } catch (InterruptedException e) {
                log.error("{}", e);
            }
        }
    }
}