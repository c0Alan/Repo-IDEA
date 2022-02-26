package com.demo.springcloud.java8.juc.basic;


import com.demo.springcloud.java8.juc.basic.thread.Thread01;
import com.demo.springcloud.java8.juc.basic.thread.Thread02;

/**
 * 线程基本功能示例
 *
 * @author liuxilin
 * @date 2022年02月23日 21:56
 */
public class ThreadExample {

    /**
     * 01.创建线程的两种方式-Thread方式
     * 参考：https://www.cnblogs.com/skywang12345/p/3479063.html
     */
    public static void example01() {
        // 启动3个线程t1,t2,t3；每个线程各卖10张票！
        Thread01 t1 = new Thread01();
        Thread01 t2 = new Thread01();
        Thread01 t3 = new Thread01();
        t1.start();
        t2.start();
        t3.start();
    }

    /**
     * 02.创建线程的两种方式-Runnable方式
     * 参考：https://www.cnblogs.com/skywang12345/p/3479063.html
     */
    public static void example02() {
        Thread02 mt = new Thread02();

        // 启动3个线程t1,t2,t3(它们共用一个Runnable对象)，这3个线程一共卖10张票！
        Thread t1 = new Thread(mt);
        Thread t2 = new Thread(mt);
        Thread t3 = new Thread(mt);
        t1.start();
        t2.start();
        t3.start();
    }
}
