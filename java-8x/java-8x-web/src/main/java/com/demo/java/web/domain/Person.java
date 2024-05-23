package com.demo.java.web.domain;

/**
 * @author liuxilin
 * @date 2018/5/5 7:54
 */
public class Person {

    private int age;

    private String home;

    private String name;

    private String sex;
    private Address address;

    public int getAge() {
        return age;
    }

    public String getHome() {
        return home;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAddress(Address address) {

        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}