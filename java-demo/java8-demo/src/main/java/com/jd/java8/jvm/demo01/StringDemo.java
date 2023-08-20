package com.jd.java8.jvm.demo01;

/**
 * 测试String对象的创建
 *
 * @author liuxilin
 * @date 2018/4/23 20:44
 */
public class StringDemo {

    public void test(){
        String str1 = "aaa";
        String str2 = "aaa";
        String str3 = new String("aaa"); // new 的对象不会放在常量池中
        System.out.println(str1 == str2); // true 说明 str2只用了常量池中的字符串
        System.out.println(str1 == str3); // false // 说明 str3 新建了一个对象
        str2 = null;
        System.out.println(str1);

        String str4 = "aaa" + "aaa";
        String str5 = str1 + str2;
        String str6 = "aaa" + "aaa";
        String str7 = "aaaaaa";
        String str8 = str1 + "aaa";
        System.out.println(str4 == str5); // false 说明 str5 也是新建对象

        // true 说明两个字符串字面量相加只创建一个对象,
        // 这里str4已经创建了字符串对象, 用了常量池中的字符串
        System.out.println(str4 == str6); // true
        System.out.println(str6 == str7); // true
        System.out.println(str6 == str8); // false
    }
}
