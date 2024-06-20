package com.demo.java.juc.basics;

import org.junit.Test;

/**
 * 创建线程的两种方式，1.继承Thread类，重写run方法，2.实现Runnable接口，重写run方法
 *
 * @author liuxl
 * @date 2024/6/20
 */
public class ThreadDemo {


    Object obj = new Object();
//    ThreadDemo obj = new ThreadDemo(); //内部类中锁对象不能用new ThreadDemo(), 会导致StackOverflowError

    public static void main(String[] args) {
        new ThreadDemo().test01();
//        new ThreadDemo().test02();
//        new ThreadDemo().test03();
//        new ThreadDemo().test04();
    }

    /**
     * synchronized
     * 这里用@Test方式运行的话，会出现程序运行完毕，但是子线程还没执行的情况，导致不打印任何信息
     * 所以需要在main里面运行
     */
    public void test04() {
        Runnable demo = new MyRunnable02();     // 新建“Runnable对象”

        Thread t1 = new Thread(demo, "t1");  // 新建“线程t1”, t1是基于demo这个Runnable对象
        Thread t2 = new Thread(demo, "t2");  // 新建“线程t2”, t2是基于demo这个Runnable对象
        t1.start();                          // 启动“线程t1”
        t2.start();                          // 启动“线程t2”
    }

    class MyRunnable02 implements Runnable {

        @Override
        public void run() {
            synchronized (obj) {
                try {
                    for (int i = 0; i < 5; i++) {
                        Thread.sleep(100); // 休眠100ms
                        System.out.println(Thread.currentThread().getName() + " loop " + i);
                    }
                } catch (InterruptedException ie) {
                    System.out.println(Thread.currentThread().getName() + " is Interrupted");
                }
            }
        }

    }

    /**
     * Runnable 实现
     */
    @Test
    public void test03(){
        Runnable mt = new MyRunnable();

        // 启动3个线程t1,t2,t3(它们共用一个Runnable对象)，这3个线程一共卖10张票！
        Thread t1 = new Thread(mt);
        Thread t2 = new Thread(mt);
        Thread t3 = new Thread(mt);
        t1.start();
        t2.start();
        t3.start();

        System.out.println("main over");
    }

    class MyRunnable implements Runnable {
        private int ticket = 10;

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                if (this.ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + " 卖票：ticket" + this.ticket--);
                }
            }
        }

    }


    /**
     * synchronized
     * 这里用@Test方式运行的话，会出现程序运行完毕，但是子线程还没执行的情况，导致不打印任何信息
     * 所以需要在main里面运行
     */
    public void test02() {
        Thread t1 = new Thread02("t1");  // 新建“线程t1”
        Thread t2 = new Thread02("t2");  // 新建“线程t2”
        t1.start();                          // 启动“线程t1”
        t2.start();                          // 启动“线程t2”

    }

    class Thread02 extends Thread {

        public Thread02(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println("线程" + Thread.currentThread().getName() + "启动！");
            // 内部类中锁对象不能用new ThreadDemo(), 会导致StackOverflowError
            synchronized (obj) {
                try {
                    for (int i = 0; i < 5; i++) {
                        Thread.sleep(100); // 休眠100ms
                        System.out.println(Thread.currentThread().getName() + " loop " + i);
                    }
                } catch (InterruptedException ie) {
                    System.out.println("线程" + Thread.currentThread().getName() + "被中断");
                }
            }
        }

    }

    /**
     * 继承Thread方式创建线程
     */
    @Test
    public void test01() {
        System.out.println(Thread.currentThread().getName());
        // 启动3个线程t1,t2,t3；每个线程各卖10张票！
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        t1.start();
        t2.start();
        t3.start();
    }


    class MyThread extends Thread {
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
}
