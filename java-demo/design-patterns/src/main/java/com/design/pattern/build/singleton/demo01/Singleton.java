package com.design.pattern.build.singleton.demo01;

/**
 * 懒汉模式, 线程不安全
 * 
 * @author liuxilin
 * @date 2018/5/19 15:23
 */
public class Singleton {

    /* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */
    private static Singleton instance = null;

    /* 私有构造方法，防止被实例化 */
    private Singleton() {
    }

    /**
     * 静态工厂方法，创建实例
     * 存在线程安全问题
     * @return
     */
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
    public Object readResolve() {
        return instance;
    }
}