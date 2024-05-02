package com.demo.java.collection;

import cn.hutool.core.date.DateTime;
import com.demo.java.entity.Person02;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.*;

/**
 * Collections 集合工具类
 *
 * @author liuxilin
 * @date 2022/7/2 21:10
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
        Person02 p1 = (new Person02(null));
        Person02 p2 = (new Person02(new DateTime("2018-06-20").toJdkDate()));
        Person02 p3 = (new Person02(new DateTime("2018-07-21").toJdkDate()));
        List<Person02> persons = new ArrayList<>();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        Person02 p = Collections.max(persons, new Comparator<Person02>() {
            @Override
            public int compare(Person02 o1, Person02 o2) {
                if(o1.getBirthDay() == null){
                    return -1;
                }
                if(o2.getBirthDay() == null){
                    return 1;
                }
                return o1.getBirthDay().getTime() - o2.getBirthDay().getTime() > 0 ? 1 : -1;
            }
        });

        System.out.println(p);
    }

    /**
     * Collections.shuffle 混排方法, 即将排序随机打乱
     */
    @Test
    public void test01() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 49; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        List<Integer> winningCombination = numbers.subList(0, 6);
        System.out.println(winningCombination);
        Collections.sort(winningCombination);
        System.out.println(winningCombination);
    }


}
