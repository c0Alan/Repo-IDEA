package com.demo.springcloud.java8.jvm.clazzloader;

/**
 * 被动使用类字段演示一：
 * 通过子类引用父类的静态字段，不会导致子类初始化
 **/
public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init!");
    }
}