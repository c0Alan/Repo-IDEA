package com.design.pattern.build.singleton.demo02;

/**
 * 内部静态类的方式创建单例, 线程安全
 *
 * @author liuxilin
 * @date 2018/5/19 15:36
 */
public class Singleton {

    /* 私有构造方法，防止被实例化 */
    private Singleton() {
    }

    /* 此处使用一个内部类来维护单例 */
    private static class SingletonFactory {
        private static Singleton instance = new Singleton();
    }

    /* 获取实例 */
    public static Singleton getInstance() {
        return SingletonFactory.instance;
    }

    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
    public Object readResolve() {
        return getInstance();
    }
}