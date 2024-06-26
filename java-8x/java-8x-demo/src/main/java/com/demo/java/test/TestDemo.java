package com.demo.java.test;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @Author liuxilin
 * @Date 2018/8/4 10:54
 */
public class TestDemo {
    public static void main(String[] args) throws ParseException {
        String path = TestDemo.class.getResource("/").getPath();
        System.out.println(path);
        System.out.println("hello world!");
        System.out.println(Integer.valueOf("1008").equals(1008));


        Map m = new HashMap();

        System.out.println(m.get("aaa"));
        System.out.println(m.get("aaa") + "");

        Byte.valueOf("1");


//        Date date = (new SimpleDateFormat("yy-MM-dd HH:mm:ss")).parse("1542806146");
        Date d = new Date(1542806146916L);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d));
    }

    @Test
    public void test01()
    {
        String str = "abc";
        String str2 = "abc";
        String str3 = new String("abc");
        String str4 = new String("abc");
        System.out.println(str == str2);
        System.out.println(str == str3);
        System.out.println(str3 == str4);
    }
}
