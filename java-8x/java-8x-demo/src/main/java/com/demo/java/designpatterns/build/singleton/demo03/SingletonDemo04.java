package com.demo.java.designpatterns.build.singleton.demo03;

/**
 * 4. 静态类内部加载, 线程安全
 * 使用内部类的好处是，静态内部类不会在单例加载时就加载，
 * 而是在调用getInstance()方法时才进行加载，达到了类似懒汉模式的效果，而这种方法又是线程安全的。
 *
 * @author liuxilin
 * @date 2018/5/19 15:32
 */
public class SingletonDemo04 {
    private static class SingletonHolder {
        private static SingletonDemo04 instance = new SingletonDemo04();
    }

    private SingletonDemo04() {
        System.out.println("Singleton has loaded");
    }

    public static SingletonDemo04 getInstance() {
        return SingletonHolder.instance;
    }
}