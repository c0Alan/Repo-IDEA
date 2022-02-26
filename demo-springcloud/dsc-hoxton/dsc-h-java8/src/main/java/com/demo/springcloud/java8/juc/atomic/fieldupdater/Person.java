package com.demo.springcloud.java8.juc.atomic.fieldupdater;

public class Person {
    volatile long id;

    public Person(long id) {
        this.id = id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}