package com.jd.java8.jvm.layout;

/**
 * JDK 1.7 之前运行时产量池存放的是常量的实例
 * JDK 1.7 之后运行时产量池存放的是常量的引用, 实例放到了堆中
 *
 * @author liuxilin
 * @date 2018/5/26 16:07
 */
public class RuntimeConstantPoolOOM02 {

    public static void main (String[]args){
        // 1.7 之前intern在常量池中创建实例
        // 1.7 之后intern在常量池中存引用
        // 中国钓鱼岛 在StringBuilder之前不存在, 第一次在常量池中创建引用, 所以为true
        String str1 = new StringBuilder("中国").append("钓鱼岛").toString();
        System.out.println(str1.intern() == str1); // 1.8 true 1.6 false

        // "java" 在StringBuilder之前就已经存在, 常量池中有引用, 所以为false
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2); // false
    }
}