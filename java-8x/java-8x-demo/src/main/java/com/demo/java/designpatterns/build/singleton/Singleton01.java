package com.demo.java.designpatterns.build.singleton;

/**
 * 1. 懒汉模式, 线程不安全
 *
 * @author liuxilin
 * @date 2018/5/19 15:28
 */
public class Singleton01 {
    private static Singleton01 instance;

    private Singleton01() {

    }

    public static Singleton01 getInstance() throws InterruptedException {
        if (instance == null) {
//            Thread.sleep(1);
            instance = new Singleton01();
        }
        return instance;
    }
}