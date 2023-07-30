package com.jd.model;

import java.util.Date;

public class Person {

    private Date birthDay;

    public Person(Date birthDay) {
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
