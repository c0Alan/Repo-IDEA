package com.demo.java.designpatterns.build.singleton.demo03;

/**
 * 2. 懒汉模式, 线程安全, 效率低
 *
 * @author liuxilin
 * @date 2018/5/19 15:36
 */
public class SingletonDemo02 {
    private static SingletonDemo02 instance;

    private SingletonDemo02() {

    }

    public static synchronized SingletonDemo02 getInstance() {
        if (instance == null) {
            instance = new SingletonDemo02();
        }
        return instance;
    }
}