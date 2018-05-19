package com.design.pattern.build.singleton.demo03;

/**
 * 3. 饿汉模式, 线程不安全, 适用于类比较小的情况下, 否则占内存
 *
 * @author liuxilin
 * @date 2018/5/19 15:36
 */
public class SingletonDemo03 {
    private static SingletonDemo03 instance = new SingletonDemo03();

    private SingletonDemo03() {

    }

    public static SingletonDemo03 getInstance() {
        return instance;
    }
}