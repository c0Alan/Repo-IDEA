package com.demo.springcloud.java8.juc.basic.priority;

/**
 * 线程优先级的示例
 *
 * cpu在执行t1和t2的时候，根据时间片轮循调度，所以能够并发执行。
 * 
 * @author liuxilin
 * @date 2018/5/20 16:24
 */
public class PriorityDemo01 {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName()
                + "(" + Thread.currentThread().getPriority() + ")");

        Thread t1 = new MyThread01("t1");    // 新建t1
        Thread t2 = new MyThread01("t2");    // 新建t2
        t1.setPriority(1);                // 设置t1的优先级为1
        t2.setPriority(10);                // 设置t2的优先级为10, t2 优先级高, t2 先运行
        t1.start();                        // 启动t1
        t2.start();                        // 启动t2
    }
}