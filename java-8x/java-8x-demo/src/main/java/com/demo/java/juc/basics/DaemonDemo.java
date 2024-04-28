package com.demo.java.juc.basics;

/**
 * @author liuxl
 * @date 2024/4/25
 * @description 守护线程
 */
public class DaemonDemo {
    public static void main(String[] args) {

        test01();
    }

    public static void test01() {
        System.out.println(Thread.currentThread().getName()
                + "(isDaemon=" + Thread.currentThread().isDaemon() + ")");

        Thread t1 = new DaemonThread02("t1");    // 新建t1
        Thread t2 = new DaemonThread01("t2");    // 新建t2
        t2.setDaemon(true);                // 设置t2为守护线程
        t1.start();                        // 启动t1
        t2.start();                        // 启动t2
    }
}