package com.demo.java.type.date;

import org.junit.Test;

import java.util.Date;

/**
 * 日期实验类
 *
 * @author liuxilin
 * @date 2018/7/7 21:30
 */
public class DateDemo {

    @Test
    public void compare(){
        Date d = new Date();

        System.out.println(d.compareTo(null));
    }
}
