package com.demo.springcloud.java8.juc.atomic.reference;

public class Person {
    volatile long id;

    public Person(long id) {
        this.id = id;
    }

    public String toString() {
        return "id:" + id;
    }
}