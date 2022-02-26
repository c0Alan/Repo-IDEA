package com.demo.springcloud.java8.juc.basic.join;

/**
 * join()介绍
 * join() 的作用：让“主线程”等待“子线程”结束之后才能继续运行。
 *
 * @author liuxilin
 * @date 2018/5/20 13:20
 */
public class JoinDemo01 {
    public static void main(String[] args) {
        Thread t = new MyThread01();
        t.start();
    }
}
