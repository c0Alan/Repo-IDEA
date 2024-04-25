package com.demo.java.java8.juc.basic.thread;

/**
 * 02.创建线程的两种方式-Runnable方式
 *
 * @author liuxilin
 * @date 2022/2/23 22:20
 */
public class Thread02 implements Runnable {
    private int ticket = 20;

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (this.ticket > 0) {
                System.out.println(Thread.currentThread().getName() + " 卖票：ticket" + this.ticket--);
            }
        }
    }
}