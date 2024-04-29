package com.demo.java.designpatterns.build.prototype;

import org.junit.Test;

import java.io.IOException;

/**
 *
 *
 * @author liuxl
 * @date 2024/4/29
 */
public class PrototypeDemo {
    public static void main(String[] args) throws Exception {
    }

    /**
     * 深拷贝
     */
    @Test
    public void test02() throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Prototype prototype = new Prototype();
        prototype.setObj(new SerializableObject());
        Prototype clone = (Prototype) prototype.deepClone();
        System.out.println(prototype.getObj() == clone.getObj());
    }

    /**
     * 浅拷贝
     */
    @Test
    public void test01() throws CloneNotSupportedException {
        Prototype prototype = new Prototype();
        prototype.setObj(new SerializableObject());
        Prototype clone = (Prototype) prototype.clone();
        System.out.println(prototype.getObj() == clone.getObj());
    }
}
