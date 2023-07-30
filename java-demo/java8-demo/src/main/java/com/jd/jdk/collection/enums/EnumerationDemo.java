package com.jd.jdk.collection.enums;

import org.junit.Test;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 枚举集合类
 * 
 * @author liuxilin
 * @date 2018/5/10 22:25
 */
public class EnumerationDemo {

    /**
     * 获取 Enumeration 对象
     */
    @Test
    public void elements(){
        Vector<String> weekDays = new Vector<String>();
        weekDays.add("Sunday");
        weekDays.add("Monday");
        weekDays.add("Tuesday");
        weekDays.add("Wednesday");
        weekDays.add("Thursday");
        weekDays.add("Friday");
        weekDays.add("Saturday");
        Enumeration<String> days = weekDays.elements();
        while (days.hasMoreElements()){
            System.out.println(days.nextElement());
        }
    }
}
