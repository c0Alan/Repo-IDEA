package com.demo.java.entity;

public class Person03 {
    private int id;
    private String name;

    public Person03(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[id=" + id + ",name=" + name + "]";
    }
}