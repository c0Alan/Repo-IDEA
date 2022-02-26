package com.demo.springcloud.java8.juc.basic.priority;

/**
 * 守护线程的示例
 * 
 * @author liuxilin
 * @date 2018/5/20 16:28
 */
public class DaemonDemo01 {

    /**
     *  t2是守护线程。在“主线程main”和“子线程t1”(它们都是用户线程)执行完毕，
     *  只剩t2这个守护线程的时候，JVM自动退出。
     * @param args
     */
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName()
                + "(isDaemon=" + Thread.currentThread().isDaemon() + ")");

        Thread t1 = new MyThread02("t1");    // 新建t1
        Thread t2 = new MyDaemon01("t2");    // 新建t2
        t2.setDaemon(true);                // 设置t2为守护线程
        t1.start();                        // 启动t1
        t2.start();                        // 启动t2
    }
}