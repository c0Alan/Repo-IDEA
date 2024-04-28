package com.demo.java.java8.jvm.layout;

import java.util.ArrayList;
import java.util.List;

/**
 * 运行时常量池导致 OOM
 * jdk 1.7 之前, 方法区运行时常量溢出 - OutOfMemoryError: PermGen space
 * jdk 1.7 之前: VM Args：-XX:PermSize=10M -XX:MaxPermSize=10M
 * jdk 1.7 之后: VM Args：-Xms20m -Xmx20m -- OutOfMemoryError: Java heap space
 * <p>
 * JDK1.7中常量池存储的不再是对象，而是对象引用，真正的对象是存储在堆中的
 * jdk 1.7 之后没有永久代了,
 *
 * @author liuxilin
 * @date 2018/5/26 11:28
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        // 使用List保持着常量池引用，避免Full GC回收常量池行为
        List<String> list = new ArrayList<String>();
        // 10MB的PermSize在integer范围内足够产生OOM了
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}