package com.demo.java.juc.basics;

/**
 * @author liuxl
 * @date 2024/4/25
 * @description 睡眠
 */
public class SleepDemo {

    private static Object obj = new Object();


    public static void main(String[] args) {
        test02();
    }

    /**
     * sleep 不会释放锁
     */
    public static void test02() {
        ThreadA t1 = new ThreadA("t1");
        ThreadA t2 = new ThreadA("t2");
        t1.start();
        t2.start();
    }

    static class ThreadA extends Thread {
        public ThreadA(String name) {
            super(name);
        }

        public void run() {
            // 获取obj对象的同步锁
            synchronized (obj) {
                try {
                    for (int i = 0; i < 10; i++) {
                        System.out.printf("%s: %d\n", this.getName(), i);
                        // i能被4整除时，休眠100毫秒
                        if (i % 4 == 0)
                            Thread.sleep(100);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 示例
     */
    public static void test01() {
        SleepThread01 t1 = new SleepThread01("t1");
        t1.start();
    }
}