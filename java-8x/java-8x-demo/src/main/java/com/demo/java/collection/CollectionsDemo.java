package com.demo.java.collection;

import com.demo.java.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.sql.Date;
import java.util.*;

/**
 * Collections 集合工具类
 *
 * @author liuxilin
 * @date 2022/7/2 21:10
 */
@Slf4j
public class CollectionsDemo {

    /**
     * Collections.sort 排序
     */
    @Test
    public void sort() {
        List<String> list = new ArrayList<String>();
        list.add("c");
        list.add("a");
        list.add("l");
        list.add("b");
        list.add("d");
        list.add("e");
        list.add("m");
        list.add("f");
        list.add("g");
        list.add("h");
        list.add("i");
        list.add("j");
        list.add("k");
        list.add("n");
        Collections.sort(list, (a, b) -> {
            return b.compareTo(a);
        });
        log.info("{}", list);
    }

    /**
     * Collections.list enumeration 转 list
     */
    @Test
    public void enumerationToList() {
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
        log.info("{}", list);
    }

    /**
     * Collections.max 获取集合最大值
     *
     * @author liuxl
     * @date 2018/7/2 11:20
     */
    @Test
    public void max() {
        Person p1 = (new Person());
        Person p2 = (new Person(Date.valueOf("2018-06-20")));
        Person p3 = (new Person(Date.valueOf("2018-07-21")));
        List<Person> persons = new ArrayList<>();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        Person p = Collections.max(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getBirthDay() == null) {
                    return -1;
                }
                if (o2.getBirthDay() == null) {
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
