package com.jd.java8.juc.basic.synchronize;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyThread02 extends Thread {

    public MyThread02(String name) {
        super(name);
    }

    @Override
    public void run() {
        int i = 1000000;
        while (i > 0) {
            try {
                Thread.sleep(20);
                log.info(String.valueOf(i));
                i--;
            } catch (InterruptedException e) {
                log.error("{}", e);
            }
        }
    }
}