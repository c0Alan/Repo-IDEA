package com.jdk.basetype;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * 整型类型测试
 *
 * @author liuxl
 * @date 2018/5/2 15:55
 */
public class TestInteger {
    private static final Logger logger = Logger.getLogger(TestInteger.class);

    /**
     * 跟int比较相等
     */
    public static void equalsInt(){
        Integer num1 = -1;
        int num2 = -1;
        int num3 = 2;
        System.out.println(num1 == num2);
        System.out.println(num1 == num3);
    }

    /**
     * 测试负数类型的Integer
     */
    public static void negativeInteger(){
        Integer num1 = -1;
        int num2 = -1;
        System.out.println(Integer.valueOf(num2).equals(num1));
    }

    /**
     * 带空格字符串转换
     */
    @Test
    public void blankString(){
//        Integer i = Integer.valueOf("123   "); // 这里加空格报错
        Integer i = Integer.valueOf("123"); // 这里加空格报错

        System.out.println(i);
    }

    /**
     * 测试拆箱
     */
    @Test
    public void equals(){
        Integer i = null;
        System.out.println(i == 1); // 这里拆箱时报空指针错误
    }

    @Test
    public void incr(){
        Integer i = 0;
        logger.info(i.hashCode());

        incr(i);
        logger.info(i); // 0

        incr(i);
        logger.info(i); // 0

        incr(i);
        logger.info(i); // 0
    }

    public void incr(Integer n){
        logger.info("before: " + n.hashCode());
        n = n + 1;
        logger.info("after: " + n.hashCode());
    }
}
