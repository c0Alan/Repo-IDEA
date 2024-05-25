package com.demo.java.web.i18n;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/**
* @Description: DateFormat类测试
* DateFormat类可以将一个日期/时间对象格式化为表示某个国家地区的日期/时间字符串
*/ 
public class DateFormatDemo {

    @Test
    public void test() throws ParseException {
        Date date = new Date(); // 当前这一刻的时间（日期、时间）

        // 输出日期部分
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL,Locale.GERMAN);
        String result = df.format(date);
        System.out.println(result);

        // 输出时间部分
        df = DateFormat.getTimeInstance(DateFormat.FULL, Locale.CHINA);
        result = df.format(date);
        System.out.println(result);

        // 输出日期和时间
        df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.LONG,Locale.CHINA);
        result = df.format(date);
        System.out.println(result);

        // 把字符串反向解析成一个date对象
        String s = "10-9-26 下午02时49分53秒";
        df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.LONG,Locale.CHINA);
        Date d = df.parse(s);
        System.out.println(d);
    }
}