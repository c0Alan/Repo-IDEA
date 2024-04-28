package com.demo.java.build.singleton.demo03;

/**
 * 6. 双重校验锁法, 线程安全
 *
 * @author liuxilin
 * @date 2018/5/19 15:42
 */
public class SingletonDemo06 {
    /** 这里加 volatile 确保读到主内存中最新的内容, 防止指令重排 */
    private volatile static SingletonDemo06 instance;

    private SingletonDemo06() {
        System.out.println("Singleton has loaded");
    }

    public static SingletonDemo06 getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo06.class) {
                if (instance == null) {
                    instance = new SingletonDemo06();
                }
            }
        }
        return instance;
    }
}