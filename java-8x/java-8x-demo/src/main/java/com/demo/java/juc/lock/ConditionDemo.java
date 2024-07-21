package com.demo.java.juc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuxl
 * @date 2024/4/26
 * @description Condition
 */
public class ConditionDemo {

    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    private static ConditionBoundedBuffer bb = new ConditionBoundedBuffer();


    public static void main(String[] args) {
        test03();
    }

    /**
     * 通过Condition，明确的指定唤醒读线程
     */
    public static void test03() {
        // 启动10个“写线程”，向BoundedBuffer中不断的写数据(写入0-9)；
        // 启动10个“读线程”，从BoundedBuffer中不断的读数据。
        for (int i = 0; i < 10; i++) {
            new PutThread("p" + i, i).start();
            new TakeThread("t" + i).start();
        }
    }

    static class PutThread extends Thread {
        private int num;

        public PutThread(String name, int num) {
            super(name);
            this.num = num;
        }

        public void run() {
            try {
                Thread.sleep(1);    // 线程休眠1ms
                bb.put(num);        // 向BoundedBuffer中写入数据
            } catch (InterruptedException e) {
            }
        }
    }

    static class TakeThread extends Thread {
        public TakeThread(String name) {
            super(name);
        }

        public void run() {
            try {
                Thread.sleep(10);                    // 线程休眠1ms
                Integer num = (Integer) bb.take();    // 从BoundedBuffer中取出数据
            } catch (InterruptedException e) {
            }
        }
    }


    /**
     * Condition 方式
     */
    public static void test02() {

        ThreadB tb = new ThreadB("tb");

        lock.lock(); // 获取锁
        try {
            System.out.println(Thread.currentThread().getName() + " start tb");
            tb.start();

            System.out.println(Thread.currentThread().getName() + " block");
            condition.await();    // 等待

            System.out.println(Thread.currentThread().getName() + " continue");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();    // 释放锁
        }
    }

    static class ThreadB extends Thread {

        public ThreadB(String name) {
            super(name);
        }

        public void run() {
            lock.lock();    // 获取锁
            try {
                System.out.println(Thread.currentThread().getName() + " wakup others");
                condition.signal();    // 唤醒“condition所在锁上的其它线程”
            } finally {
                lock.unlock();    // 释放锁
            }
        }
    }


    /**
     * synchronized 方式
     */
    public static void test01() {
        ThreadA ta = new ThreadA("ta");

        synchronized (ta) { // 通过synchronized(ta)获取“对象ta的同步锁”
            try {
                System.out.println(Thread.currentThread().getName() + " start ta");
                ta.start();

                System.out.println(Thread.currentThread().getName() + " block");
                ta.wait();    // 等待

                System.out.println(Thread.currentThread().getName() + " continue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ThreadA extends Thread {

        public ThreadA(String name) {
            super(name);
        }

        public void run() {
            synchronized (this) { // 通过synchronized(this)获取“当前对象的同步锁”
                System.out.println(Thread.currentThread().getName() + " wakup others");
                notify();    // 唤醒“当前对象上的等待线程”
            }
        }
    }
}