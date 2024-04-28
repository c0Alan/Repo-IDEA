package com.demo.java.designpatterns.build.singleton.demo03;

/**
 * 1. 懒汉模式, 线程不安全
 *
 * @author liuxilin
 * @date 2018/5/19 15:28
 */
public class SingletonDemo01 {
    private static SingletonDemo01 instance;

    private SingletonDemo01() {

    }

    public static SingletonDemo01 getInstance() throws InterruptedException {
        if (instance == null) {
//            Thread.sleep(1);
            instance = new SingletonDemo01();
        }
        return instance;
    }
}