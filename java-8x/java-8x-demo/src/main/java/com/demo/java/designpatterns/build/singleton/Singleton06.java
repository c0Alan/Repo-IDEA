package com.demo.java.designpatterns.build.singleton;

/**
 * 6. dcl 双重校验锁法, 线程安全
 *
 * @author liuxilin
 * @date 2018/5/19 15:42
 */
public class Singleton06 {
    /** 这里加 volatile 确保读到主内存中最新的内容, 防止指令重排 */
    private volatile static Singleton06 instance;

    private Singleton06() {
        System.out.println("Singleton has loaded");
    }

    public static Singleton06 getInstance() {
        if (instance == null) {
            synchronized (Singleton06.class) {
                if (instance == null) {
                    instance = new Singleton06();
                }
            }
        }
        return instance;
    }
}