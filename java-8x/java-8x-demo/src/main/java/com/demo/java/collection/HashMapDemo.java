package com.demo.java.collection;

import com.demo.java.entity.Employee04;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        Map<String, Employee04> staff = new HashMap<>();
        staff.put("144-25-5464", new Employee04("Amy Lee"));
        staff.put("567-24-2546", new Employee04("Harry Hacker"));
        staff.put("157-62-7935", new Employee04("Gary Cooper"));
        staff.put("456-62-5527", new Employee04("Francesca Cruz"));

        // print all entries

        System.out.println(staff);

        // remove an entry

        staff.remove("567-24-2546");

        // replace an entry

        staff.put("456-62-5527", new Employee04("Francesca Miller"));

        // look up a value

        System.out.println(staff.get("157-62-7935"));

        // iterate through all entries

        staff.forEach((k, v) ->
                System.out.println("key=" + k + ", value=" + v));
    }
}
