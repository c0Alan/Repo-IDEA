package com.demo.java.collection.util;

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

    /**
     * 获取集合最大值
     * 
     * @author liuxl
     * @date 2018/7/2 11:20
     */
    @Test
    public void max(){
        /*Person p1 = (new Person(null));
        Person p2 = (new Person(new DateTime("2018-06-20").toDate()));
        Person p3 = (new Person(new DateTime("2018-07-21").toDate()));
        List<Person> persons = new ArrayList<>();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        Person p = Collections.max(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.getBirthDay() == null){
                    return -1;
                }
                if(o2.getBirthDay() == null){
                    return 1;
                }
                return o1.getBirthDay().getTime() - o2.getBirthDay().getTime() > 0 ? 1 : -1;
            }
        });

        System.out.println(p);*/
    }
}
