package com.demo.java.collection.list;

import com.demo.java.model.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArrayListDemo {

    @Test
    public void test(){
        List<Person> list = new ArrayList<>();
        list.add(new Person(new Date()));
        list.add(new Person(new Date()));
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
