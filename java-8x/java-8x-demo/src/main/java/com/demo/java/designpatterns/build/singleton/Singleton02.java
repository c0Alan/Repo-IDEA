package com.demo.java.designpatterns.build.singleton;

/**
 * 2. 懒汉模式, 线程安全, 效率低
 *
 * @author liuxilin
 * @date 2018/5/19 15:36
 */
public class Singleton02 {
    private static Singleton02 instance;

    private Singleton02() {

    }

    public static synchronized Singleton02 getInstance() {
        if (instance == null) {
            instance = new Singleton02();
        }
        return instance;
    }
}