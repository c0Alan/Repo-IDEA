package com.demo.java.java8.juc.basic.thread;

/**
 * 01.创建线程的两种方式-Thread方式
 *
 * @author liuxilin
 * @date 2022/2/23 22:20
 */
public class Thread01 extends Thread {
    private int ticket = 10;

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (this.ticket > 0) {
                System.out.println(this.getName() + " 卖票：ticket" + this.ticket--);
            }
        }
    }
}