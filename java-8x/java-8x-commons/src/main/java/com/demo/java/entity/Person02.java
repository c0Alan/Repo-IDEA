package com.demo.java.entity;

import java.util.Date;

public class Person02 {

    private Date birthDay;

    public Person02(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return "Person{" +
                "birthDay=" + birthDay +
                '}';
    }

}
