package com.demo.java.java8.juc.basic.yield;

/**
 * yield()示例
 * yield()的作用是让步。 yield是让出cpu执行时间片，而不让出资源锁。
 * 它能让当前线程由“运行状态”进入到“就绪状态”，从而让其它具有相同优先级的等待线程获取执行权；
 * 但是，并不能保证在当前线程调用yield()之后，其它具有相同优先级的线程就一定能获得执行权；
 * 也有可能是当前线程又进入到“运行状态”继续运行！
 * <p>
 * (01) wait()是让线程由“运行状态”进入到“等待(阻塞)状态”，而不yield()是让线程由“运行状态”进入到“就绪状态”。
 * (02) wait()是会线程释放它所持有对象的同步锁，而yield()方法不会释放锁。
 *
 * @author liuxilin
 * @date 2018/5/20 11:23
 */
public class YieldDemo01 {
    /**
     * 完全没有试出来yield的作用
     * 原因是 yield 不释放锁
     *
     * @param args
     */
    public static void main(String[] args) {
        Object obj = new Object();
        MyThread01 t1 = new MyThread01("t1", obj);
        MyThread01 t2 = new MyThread01("t2", obj);
        t1.start();
        t2.start();
    }
}