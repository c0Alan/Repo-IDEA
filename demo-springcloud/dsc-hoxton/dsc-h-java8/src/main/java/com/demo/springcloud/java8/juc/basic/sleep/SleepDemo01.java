package com.demo.springcloud.java8.juc.basic.sleep;

/**
 * sleep()的作用是也是让当前线程由“运行状态”进入到“休眠(阻塞)状态”。
 * sleep()不会释放锁
 *
 * @author liuxilin
 * @date 2018/5/20 13:13
 */
public class SleepDemo01 {
    public static void main(String[] args) {
        MyThread01 t1 = new MyThread01("t1");
        t1.start();
    }
}