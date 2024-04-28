package com.demo.java.juc.atomic;

class Person {
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

    @Override
    public String toString() {
        return "id:" + id;
    }
}