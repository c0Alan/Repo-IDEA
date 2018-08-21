package com.jdk.clazz.extend;

/**
 * @author liuxilin
 * @version 2018/8/21
 * @Copyright (C)2018 , Suntektech
 * @since
 */
public class ChildDemo02 extends ParentDemo01 {
    public static void main(String[] args) {
        ChildDemo02 demo02 = new ChildDemo02();
        ChildDemo01 demo01 = new ChildDemo01();

        demo01.printList();
        demo02.printList();

    }
}
