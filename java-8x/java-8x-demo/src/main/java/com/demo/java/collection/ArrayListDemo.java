package com.demo.java.collection;

import com.demo.java.entity.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

/**
 *
 *
 * @author liuxl
 * @date 2024/5/2
 */
public class ArrayListDemo {

    @Test
    public void test(){
        List<Person> list = new ArrayList<>();
        list.add(new Person(Date.valueOf("2024-05-02")));
        list.add(new Person(Date.valueOf("2024-05-02")));
        Person p = list.get(1);
        System.out.println(p == list.get(1));
        list = null;
        System.out.println(p);
        System.out.println(list);
    }

    @Test
    public void sublist(){
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");
        list.add("ee");
        List<String> subList = list.subList(0, 3);
        System.out.println(subList); // [aa, bb, cc]
        subList.clear();
        System.out.println(list.size()); // 2
        System.out.println(list); // [dd, ee]
    }
}
