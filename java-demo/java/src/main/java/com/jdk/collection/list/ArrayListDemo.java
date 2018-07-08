package com.jdk.collection.list;

import com.model.Person;
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
}
