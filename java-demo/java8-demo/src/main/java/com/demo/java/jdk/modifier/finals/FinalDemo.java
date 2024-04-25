package com.demo.java.jdk.modifier.finals;

import org.junit.Test;

/**
 * 当用final修饰一个类时，表明这个类不能被继承。
 *
 * @author liuxl
 * @date 2018/5/31 12:45
 */
public final class FinalDemo extends ParentFinalDemo {

    /**
     * 使用final 关键字修饰一个变量时, 是指引用变量不能变
     */
    @Test
    public void finalVariable() {
        final StringBuffer a = new StringBuffer("immutable");
//        a = new StringBuffer(""); // 这里将报告编译期错误
        a.append(" broken!"); // 这里不报错
    }

    // final 修饰的方法不能被子类覆盖
/*    public void finalMethod(){

    }*/

    // 子类 无法继承 final 类
/*    class SubFinalDemo extends FinalDemo{

    }*/

    /**
     * 当final变量是基本数据类型以及String类型时，
     * 如果在编译期间能知道它的确切值，则编译器会把它当做编译期常量使用。
     * String c = b + 2; 对 b 做了代码直接替换, 而不是 通过 "hello" 对象来创建
     * 注意，只有在编译期间能确切知道final变量值的情况下，编译器才会进行这样的优化
     */
    @Test
    public void test01() {
        String a = "hello2";
        final String b = "hello"; // 值确定, 编译器会把它当做编译期常量
        String d = "hello";
        String c = b + 2; // 直接代码替换, 对String进行优化, 直接取常量池中的对象
        String e = d + 2;
        System.out.println((a == c)); // true
        System.out.println((a == e)); // false
    }

    /**
     * final String b 在运行期才确定的对象,
     * 注意，只有在编译期间能确切知道final变量值的情况下，编译器才会进行这样的优化
     */
    @Test
    public void test02(){
        String a = "hello2";
        final String b = getHello();  // 值在运行期才确定
        String c = b + 2;
        System.out.println((a == c)); // false
    }

    public static String getHello() {
        return "hello";
    }
}

