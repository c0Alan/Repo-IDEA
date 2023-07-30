package com.jd.jdk.type.string;

import org.junit.Test;

public class StringDemo02 {

    /**
     * JDK1.6中，intern()方法会把首次遇到的字符串复制到永久代中，返回的也是永久代中这个字符串的引用，
     * 而由StringBuilder创建的字符串实例在Java堆中，所以必然不是同一个引用，将返回false
     *
     * JDK1.7(以及部分其他虚拟机，例如JRockit)的intern()实现不会再复制实例，
     * 而是在常量池中记录首次出现的实例引用，因此intern()返回的引用和由StringBuilder创建的那个字符串是同一个。
     *
     * 因为"java"字符串在执行StringBuilder()之前就已经出现过，字符串常量池中已经有它的引用了，
     * 不符合“首次出现”原则，而“计算机软件”这个字符串则是首次出现的，因此返回true。
     */
    @Test
    public void testIntern() {
        printJdkVersion();
        testAndPrintResult("计算机", "软件"); // 1.8 true 1.6 false
        testAndPrintResult("ja", "va"); // false
        testAndPrintResult("ma", "in"); // false
    }

    private static void testAndPrintResult(String prefix, String suffix) {
        String str3 = new StringBuilder(prefix).append(suffix).toString();
        System.out.println(str3.intern() == str3);
    }

    private static void printJdkVersion() {
        String javaVersion = "java.version";
        System.out.println(javaVersion + ":" + System.getProperty(javaVersion));
    }
}