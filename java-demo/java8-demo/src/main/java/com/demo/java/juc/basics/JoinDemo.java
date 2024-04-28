package com.demo.java.juc.basics;

import lombok.SneakyThrows;

/**
 * @author liuxl
 * @date 2024/4/25
 * @description join() 的作用：让“主线程”等待“子线程”结束之后再继续运行
 */
public class JoinDemo {

    private static Object obj = new Object();

    public static void main(String[] args) {
        test02();
    }

    /**
     * join不会释放锁
     */
    public static void test02() {
        try {
            ThreadB t1 = new ThreadB("t1"); // 新建“线程t1”
            ThreadB t2 = new ThreadB("t2"); // 新建“线程t1”
            ThreadB t3 = new ThreadB("t3"); // 新建“线程t1”

//            synchronized (obj) {
            System.out.printf("%s start\n", Thread.currentThread().getName());
            t2.start();                     // 启动“线程t1”
            t3.start();                     // 启动“线程t1”
            t1.start();                     // 启动“线程t1”
            t1.join();                        // 将“线程t1”加入到“主线程main”中，并且“主线程main()会等待它的完成”
            System.out.printf("%s finish\n", Thread.currentThread().getName());

//            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class ThreadB extends Thread {

        public ThreadB(String name) {
            super(name);
        }

        @SneakyThrows
        public void run() {
            synchronized (obj) {
                System.out.printf("%s start\n", this.getName());

                // 延时操作
                Thread.sleep(3000);

                System.out.printf("%s finish\n", this.getName());
            }
        }
    }

    /**
     * 将“线程t1”加入到“主线程main”中，并且“主线程main()会等待它的完成
     */
    public static void test01() {
        try {
            ThreadA t1 = new ThreadA("t1"); // 新建“线程t1”

            t1.start();                     // 启动“线程t1”
            t1.join();                        // 将“线程t1”加入到“主线程main”中，并且“主线程main()会等待它的完成”
            System.out.printf("%s finish\n", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class ThreadA extends Thread {

        public ThreadA(String name) {
            super(name);
        }

        @SneakyThrows
        public void run() {
            System.out.printf("%s start\n", this.getName());

            // 延时操作
            sleep(2000);

            System.out.printf("%s finish\n", this.getName());
        }
    }
}
