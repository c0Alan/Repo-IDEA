package com.demo.java.designpatterns.build.singleton;

/**
 * 3. 饿汉模式, 线程不安全, 适用于类比较小的情况下, 否则占内存
 *
 * @author liuxilin
 * @date 2018/5/19 15:36
 */
public class Singleton03 {
    private static Singleton03 instance = new Singleton03();

    private Singleton03() {

    }

    public static Singleton03 getInstance() {
        return instance;
    }
}