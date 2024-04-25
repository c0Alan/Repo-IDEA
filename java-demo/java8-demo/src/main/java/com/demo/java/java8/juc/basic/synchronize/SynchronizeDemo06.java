package com.demo.java.java8.juc.basic.synchronize;

/**
 * 实例锁 和 全局锁
 * (01) 不能被同时访问。因为isSyncA()和isSyncB()都是访问同一个对象(对象x)的同步锁！
 *
 * 实例锁 -- 锁在某一个实例对象上。如果该类是单例，那么该锁也具有全局锁的概念。
 * 实例锁对应的就是synchronized关键字。
 * 全局锁 -- 该锁针对的是类，无论实例多少个对象，那么线程都共享该锁。
 * 全局锁对应的就是static synchronized（或者是锁在该类的class或者classloader对象上）。
 *
 * @author liuxilin
 * @date 2018/5/20 9:47
 */
public class SynchronizeDemo06 {

    Something x = new Something();
    Something y = new Something();

    /**
     * 比较(01) x.isSyncA()与x.isSyncB()
     */
    private void test1() {
        // 新建t11, t11会调用 x.isSyncA()
        Thread t11 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        x.isSyncA();
                    }
                }, "t11");

        // 新建t12, t12会调用 x.isSyncB()
        Thread t12 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        x.isSyncB();
                    }
                }, "t12");


        t11.start();  // 启动t11
        t12.start();  // 启动t12
    }

    public static void main(String[] args) {
        SynchronizeDemo06 demo = new SynchronizeDemo06();
        demo.test1();
    }
}