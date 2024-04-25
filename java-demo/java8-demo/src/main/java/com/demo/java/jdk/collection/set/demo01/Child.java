package com.demo.java.jdk.collection.set.demo01;

public class Child extends Parent {
    public Child() {
        super(3);
    }

    public int compareTo(Object o) {
        System.out.println("method of child");
        return 1;
    }
}