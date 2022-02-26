package com.demo.springcloud.java8.juc.lock.locksupport;

import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport 可以指定唤醒的线程
 *
 * @author liuxilin
 * @date 2018/5/23 10:26
 */
public class LockSupportTest1 {

    private static Thread mainThread;
    private static Object obj = new Object();

    public static void main(String[] args) {

        ThreadA ta = new ThreadA("ta");
        // 获取主线程
        mainThread = Thread.currentThread();

        System.out.println(Thread.currentThread().getName()+" start ta");
        ta.start();

        System.out.println(Thread.currentThread().getName()+" block");
        // 主线程阻塞
//        LockSupport.park(mainThread);
        LockSupport.park(obj);

        System.out.println(Thread.currentThread().getName()+" continue");
    }

    static class ThreadA extends Thread{

        public ThreadA(String name) {
            super(name);
        }

        public void run() {
            System.out.println(Thread.currentThread().getName()+" wakup others");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 唤醒“主线程”
//            LockSupport.unpark(mainThread);
            LockSupport.unpark(mainThread);
        }
    }
}