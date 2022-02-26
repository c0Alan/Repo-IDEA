package com.demo.springcloud.java8.juc.basic.synchronize;

/**
 * 实例锁 和 全局锁
 * (04) 可以被同时访问。
 * 因为isSyncA()是实例方法，x.isSyncA()使用的是对象x的锁；
 * 而cSyncA()是静态方法，Something.cSyncA()可以理解对使用的是“类的锁”。因此，它们是可以被同时访问的。
 *
 * @author liuxilin
 * @date 2018/5/20 9:55
 */
public class SynchronizeDemo09 {

    Something x = new Something();
    Something y = new Something();

    // 比较(04) x.isSyncA()与Something.cSyncA()
    private void test4() {
        // 新建t41, t41会调用 x.isSyncA()
        Thread t41 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        x.isSyncA();
                    }
                }, "t41");

        // 新建t42, t42会调用 x.isSyncB()
        Thread t42 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        Something.cSyncA();
                    }
                }, "t42");


        t41.start();  // 启动t41
        t42.start();  // 启动t42
    }

    public static void main(String[] args) {
        SynchronizeDemo09 demo = new SynchronizeDemo09();

        demo.test4();
    }
}