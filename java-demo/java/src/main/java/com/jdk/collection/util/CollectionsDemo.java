package com.jdk.collection.util;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

/**
 * java 集合工具类
 * 
 * @author liuxilin
 * @date 2018/5/10 22:23
 */
public class CollectionsDemo {
    private static final Logger logger = Logger.getLogger(CollectionsDemo.class);

    /**
     * enumeration 转 list
     */
    @Test
    public void enumerationToList(){
        Vector<String> weekDays = new Vector<String>();
        weekDays.add("Sunday");
        weekDays.add("Monday");
        weekDays.add("Tuesday");
        weekDays.add("Wednesday");
        weekDays.add("Thursday");
        weekDays.add("Friday");
        weekDays.add("Saturday");
        Enumeration<String> days = weekDays.elements();
        List<String> list = Collections.list(days);
        logger.info(list);
    }
}
