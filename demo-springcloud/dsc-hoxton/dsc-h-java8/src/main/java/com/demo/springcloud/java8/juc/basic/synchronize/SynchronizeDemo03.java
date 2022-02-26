package com.demo.springcloud.java8.juc.basic.synchronize;

/**
 * 2. 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，
 * 其他线程仍然可以访问“该对象”的非同步代码块。
 *
 * @author liuxilin
 * @date 2018/5/20 9:33
 */
public class SynchronizeDemo03 {

    public static void main(String[] args) {
        final Count count = new Count();
        // 新建t1, t1会调用“count对象”的synMethod()方法
        Thread t1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        count.synMethod();
                    }
                }, "t1");

        // 新建t2, t2会调用“count对象”的nonSynMethod()方法
        Thread t2 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        count.nonSynMethod();
                    }
                }, "t2");


        t1.start();  // 启动t1
        t2.start();  // 启动t2
    }
}