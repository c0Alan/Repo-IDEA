package com.demo.java.clazz;

import org.junit.Test;

import java.util.Date;

public class ExtendsSupperDemo extends Date {

    /**
     * 哪个类里调 getClass 就返回哪个类的 Class 实例
     */
    @Test
    public void testGetClass() {
        System.out.println(super.getClass().getName()); // com.jd.jdk.clazz.extend.SupperDemo
        System.out.println(getClass().getSuperclass().getName()); // java.util.Date
    }

}