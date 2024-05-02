package com.demo.java.collection.set.demo01;

public class Parent implements Comparable {
    private int age = 0;

    public Parent(int age) {
        this.age = age;
    }

    public int compareTo(Object o) {
        System.out.println("method of parent");
        Parent o1 = (Parent) o;
        return age > o1.age ? 1 : age < o1.age ? -1 : 0;
    }
}