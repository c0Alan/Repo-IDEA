package com.demo.java.juc.basics;

/**
 * @author liuxl
 * @date 2024/4/25
 * @description 线程优先级
 */
public class PriorityDemo {
    public static void main(String[] args) {

        test01();
    }

    /**
     * 优先级的范围是1～10，默认的优先级是5，数值越大优先级越高
     */
    public static void test01(){
        System.out.println(Thread.currentThread().getName()
                + "(" + Thread.currentThread().getPriority() + ")");

        Thread t1 = new PriorityThread("t1");    // 新建t1
        Thread t2 = new PriorityThread("t2");    // 新建t2
        t1.setPriority(1);                // 设置t1的优先级为1
        t2.setPriority(10);                // 设置t2的优先级为10
        t1.start();                        // 启动t1
        t2.start();                        // 启动t2
    }
}