package com.demo.java.jdk.type.shorts;

import org.junit.Test;

public class ShortDemo {

    /**
     * short 类型测试
     * 最小值：Short.MIN_VALUE=-32768 （-2的15此方）
     * 最大值：Short.MAX_VALUE=32767 （2的15次方-1）
     */
    @Test
    public void toInt() {
        short s1 = 1; // s1+1运算时会自动提升表达式的类型, 所以结果是int型
//        s1 = s1 + 1; // 再赋值给short 类型s1时, 编译器将报告需要强制转换类型的错误。
        s1 = (short) (s1 + 1); // 强制类型转换之后不报错
        s1 += 1; // += 是java 语言规定的运算符, java 编译器会对它进行特殊处理, 因此可以正确编译。

//        s1 = 32768; // 超过 32767 就报错
        s1 = 32767; // 超过 32767 就报错
        s1 += 1; // 这样就报错, 结果为 -32768
        System.out.println(s1); // -32768
    }
}
