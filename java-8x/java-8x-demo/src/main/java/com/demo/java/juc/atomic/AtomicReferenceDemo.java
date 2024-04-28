package com.demo.java.juc.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author liuxl
 * @date 2024/4/26
 * @description 引用类型 AtomicReference
 */
public class AtomicReferenceDemo {

    public static void main(String[] args) {
        test01();
    }

    public static void test01() {
        // 创建两个Person对象，它们的id分别是101和102。
        Person p1 = new Person(101);
        Person p2 = new Person(102);
        // 新建AtomicReference对象，初始化它的值为p1对象
        AtomicReference ar = new AtomicReference(p1);
        // 通过CAS设置ar。如果ar的值为p1的话，则将其设置为p2。
        ar.compareAndSet(p1, p2);

        Person p3 = (Person) ar.get();
        System.out.println("p3 is " + p3);
        System.out.println("p3.equals(p1)=" + p3.equals(p1));
    }
}
