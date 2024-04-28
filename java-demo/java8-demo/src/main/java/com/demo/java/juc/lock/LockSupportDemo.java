package com.demo.java.juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport
 * <p>
 * LockSupport.park()和LockSupport.unpark(Thread)
 * <p>
 * LockSupport.park()：暂停当前线程，当前线程调用park()方法后，会放弃对象锁，进入等待状态
 * LockSupport.unpark(Thread)：恢复某个线程的运行
 * <p>
 * LockSupport.park()和LockSupport.unpark(Thread)这两个方法都是静态方法，并且都是通过Thread类中的
 * private transient volatile Thread parkBlocker;对象来维护线程的运行状态的
 */
public class LockSupportDemo {

    private static Thread mainThread;

    public static void main(String[] args) {
        test01();
    }

    /**
     * unpark 先于 park 执行也可以
     */
    public static void test01() {
        ThreadA ta = new ThreadA("ta");
        // 获取主线程
        mainThread = Thread.currentThread();

        System.out.println(Thread.currentThread().getName() + " start ta");
        ta.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " block");

        // 主线程阻塞
        LockSupport.park(mainThread);

        System.out.println(Thread.currentThread().getName() + " continue");

    }

    static class ThreadA extends Thread {

        public ThreadA(String name) {
            super(name);
        }

        public void run() {
            System.out.println(Thread.currentThread().getName() + " wakup others");
            // 唤醒“主线程”
            LockSupport.unpark(mainThread);
            System.out.println(Thread.currentThread().getName() + " wakup others");
        }
    }
}