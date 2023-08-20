package com.jd.java8.jvm.layout;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 本机直接内存溢出 // OutOfMemoryError
 * VM Args：-Xmx20M -XX:MaxDirectMemorySize=10M
 *
 * 直接内存溢出的特征是 Heap Dump 文件不会看到明显异常, 如果Dump文件很小,
 * 而且程序中直接或间接的使用了NIO, 可以考虑是不是直接内存溢出引起的
 * 
 * @author liuxilin
 * @date 2018/5/26 15:58
 */
public class DirectMemoryOOM {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}