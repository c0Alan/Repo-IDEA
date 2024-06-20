package com.demo.java.basic;

import com.demo.java.enums.Color;
import org.junit.Test;

/**
 * Java 基础知识示例
 *
 * @author liuxl
 * @date 2024/6/17
 */
public class BasicDemo {

    /**
     * Assert 断言
     */
    @Test
    public void test07() {
        int a = 1;
        int b = 2;
        b--;
        assert a + b == 3;
    }

    /**
     * 基础数据类型： byte, short, int, long, float, double, boolean, char
     */
    @Test
    public void test06() {
        short s1 = 1;
//        s1 = s1 + 1; // 编译错误, +1 后转成int类型，无法赋值给short
        s1 += 1; // += 运算符后转成short类型
        System.out.println(s1);

    }


    /**
     * 测试 switch 语句
     */
    @Test
    public void test05() {
        byte b = 1;
        short s = 1;
        char c = '1';
        long l = 1;
        String str = "1";
        Color color = Color.GREEN;

        switch (b) { // good
            case 1:
                System.out.println("byte good");
                break;
            default:
                System.out.println("byte bad");
        }

        switch (s) { // good
            case 1:
                System.out.println("short good");
                break;
            default:
                System.out.println("short bad");
        }

        System.out.println((int)c); // 49
        switch (c) { // bad 此处会进行类型转换, char 转换为 int
            case 1:
                System.out.println("good");
                break;
            default:
                System.out.println("bad");
        }

        switch (c) { // good
            case '1':
                System.out.println("char good");
                break;
            default:
                System.out.println("char bad");
        }

        /*switch (l) { // 此处报错, long 类型不支持 switch, 因为long 无法向下转换为 Int 型
            case 1:
                System.out.println("good");
                break;
            default:
                System.out.println("bad");
        }*/

        switch (str) { // good
            case "1":
                System.out.println("String good");
                break;
            default:
                System.out.println("String bad");
        }

        switch (color) { // good
            case GREEN:
                System.out.println("Color good");
                break;
            default:
                System.out.println("Color bad");
        }

    }


    /**
     * & 跟 && 区别
     * 都可以作为逻辑运算符, && 具有短路功能，如果左边为false，则右边不会执行。
     * & 还可以作为位运算符
     */
    @Test
    public void test04() {
        int a = 1;
        int b = 2;
        int c = 3;
        // && 具有短路功能，a>b为false，c++不会执行
        System.out.println(a > b && c++ > 0);
        System.out.println(c);
        // a>b为false，c++会执行
        System.out.println(a > b & c++ > 0);
        System.out.println(c);

        // & 作为位运算符
        System.out.println( 1 & 2);
    }

    /**
     * Integer 类型, 128陷阱
     * https://blog.csdn.net/qq_61024956/article/details/137033282
     */
    @Test
    public void test03() {
        Integer a = 127;
        Integer b = 127;
        System.out.println(a == b);
        Integer c = 128;
        Integer d = 128;
        System.out.println(c == d);
    }

    /**
     * 位运算符
     */
    @Test
    public void test02() {
        int a = 8;
        int b = 2;
        System.out.println(a & b);
        System.out.println(a | b);
        System.out.println(a ^ b);
        System.out.println(~a);
        // 左移n位, a * 2^n
        System.out.println(a << 2);
        // 右移n位, a / 2^n
        System.out.println(a >> 2);
        System.out.println(a >>> 1);
    }

    /**
     * ++ 操作符
     */
    @Test
    public void test01() {
        int x = 1;
        // 先赋值，再加一
        System.out.println(x++);
        x = 1;
        // 先加一，再赋值
        System.out.println(++x);
    }
}
