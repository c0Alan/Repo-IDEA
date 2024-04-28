package com.demo.java.juc.basics;

/**
 * @author liuxl
 * @date 2024/4/25
 * @description 线程让步
 */
public class YieldDemo {

    private static Object obj = new Object();

    public static void main(String[] args) {
        test02();
    }

    /**
     * 不会释放锁
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
                for (int i = 0; i < 10; i++) {
                    System.out.printf("%s [%d]:%d\n", this.getName(), this.getPriority(), i);
                    // i整除4时，调用yield
                    if (i % 4 == 0)
                        Thread.yield();
                }
            }
        }
    }

    /**
     * 线程让步，不一定会让其它线程获取CPU执行权
     */
    public static void test01() {
        YieldThread01 t1 = new YieldThread01("t1");
        YieldThread01 t2 = new YieldThread01("t2");
        t1.start();
        t2.start();
    }
}