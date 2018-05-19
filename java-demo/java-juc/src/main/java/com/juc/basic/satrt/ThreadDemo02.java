package com.juc.basic.satrt;

/**
 * 创建线程的方式 2: Runnable 的方式
 * 
 * @author liuxilin
 * @date 2018/5/19 22:51
 */
public class ThreadDemo02 {
    public static void main(String[] args) {
        MyRunnable01 mr = new MyRunnable01();

        // 启动3个线程t1,t2,t3(它们共用一个Runnable对象)，这3个线程一共卖10张票！
        Thread t1 = new Thread(mr);
        Thread t2 = new Thread(mr);
        Thread t3 = new Thread(mr);
        t1.start();
        t2.start();
        t3.start();
    }
}