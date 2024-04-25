package com.demo.java.test;

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
public class Test {
    public static void main(String[] args) throws ParseException {
        String path = Test.class.getResource("/").getPath();
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
}
