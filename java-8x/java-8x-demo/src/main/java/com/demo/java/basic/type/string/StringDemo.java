package com.demo.java.basic.type.string;

//import org.apache.log4j.Logger;

/**
 * jdk string 包测试
 *
 * @author liuxl
 * 2017-9-27 下午2:34:19
 */
public class StringDemo {
//    private static Logger logger = Logger.getLogger(StringDemo.class);

    /**
     * 测试 String 类
     * <p>
     * 2017-9-27 下午2:34:49
     */
    public void testString() {

        /** matches 函数: String 的正则表达式匹配 */
//        String str1 = null;
        String str1 = "aaa.bbb_dd_gg";
        String str2 = "aaa.bbb_dd_kk";
        boolean result = str1.matches("aaa\\.bbb_.*_gg");
//        logger.info("" + result);
        result = str2.matches("aaa\\.bbb_.*_gg");
//        logger.info("" + result);

    }

    public void intern() {
        String s1 = new String("aaa");
        String s2 = "aaa";
        System.out.println(s1 == s2);    // false

        s1 = new String("bbb").intern();
        s2 = "bbb";
        System.out.println(s1 == s2);    // true

        s1 = "ccc";
        s2 = "ccc";
        System.out.println(s1 == s2);    // true

        s1 = new String("ddd").intern();
        s2 = new String("ddd").intern();
        System.out.println(s1 == s2);    // true

        s1 = "ab" + "cd";
        s2 = "abcd";
        System.out.println(s1 == s2);    // true

        String temp = "hh";
        s1 = "a" + temp;
        // 如果调用s1.intern 则最终返回true
        s2 = "ahh";
        System.out.println(s1 == s2);    // false

        temp = "hh".intern();
        s1 = "a" + temp;
        s2 = "ahh";
        System.out.println(s1 == s2);    // false

        temp = "hh".intern();
        s1 = ("a" + temp).intern();
        s2 = "ahh";
        System.out.println(s1 == s2);    // true

        // 同时会生成堆中的对象 以及常量池中1的对象，但是此时s1是指向堆中的对象的
        s1 = new String("1");

        // 常量池中的已经存在
        s1.intern();
        s2 = "1";
        System.out.println(s1 == s2);    // false

        // 此时生成了四个对象 常量池中的"1" + 2个堆中的"1" + s3指向的堆中的对象（注此时常量池不会生成"11"）
        String s3 = new String("1") + new String("1");
        s3.intern();  // jdk1.7之后，常量池不仅仅可以存储对象，还可以存储对象的引用，会直接将s3的地址存储在常量池
        String s4 = "11";    // jdk1.7之后，常量池中的地址其实就是s3的地址
        System.out.println(s3 == s4); // jdk1.7之前false， jdk1.7之后true

        s3 = new String("2") + new String("2");
        s4 = "22";        // 常量池中不存在22，所以会新开辟一个存储22对象的常量池地址
        s3.intern();    // 常量池22的地址和s3的地址不同
        System.out.println(s3 == s4); // false

        // 对于什么时候会在常量池存储字符串对象，我想我们可以基本得出结论: 1. 显示调用String的intern方法的时候; 2. 直接声明字符串字面常量的时候，例如: String a = "aaa";
        // 3. 字符串直接常量相加的时候，例如: String c = "aa" + "bb";  其中的aa/bb只要有任何一个不是字符串字面常量形式，都不会在常量池生成"aabb". 且此时jvm做了优化，不//   会同时生成"aa"和"bb"在字符串常量池中
    }
}
