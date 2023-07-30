package com.jd.jdk.collection.set.demo01;

import java.util.TreeSet;

/**
 * TreeSet 里面放对象, 如果同时放入了父类和子类的实例对象,
 * 那比较时使用的是父类的compareTo 方法, 还是使用的子类的compareTo 方法, 还是抛异常！
 * 当前的add方法放入的是哪个对象, 就调用哪个对象的compareTo方法
 *
 * @author liuxl
 * @date 2018/6/8 12:35
 */
public class TreeSetDemo {

    public static void main(String[] args) {
        TreeSet set = new TreeSet();
        set.add(new Parent(3));
        set.add(new Child());
        set.add(new Parent(4));
        System.out.println(set.size());
    }
}