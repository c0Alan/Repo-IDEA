package com.demo.java.entity;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee07 implements Cloneable {
    private String name;
    private double salary;
    private Date hireDay;

    public Employee07(String name, double salary) {
        this.name = name;
        this.salary = salary;
        hireDay = new Date();
    }

    @Override
    public Employee07 clone() throws CloneNotSupportedException {
        // call Object.clone()
        Employee07 cloned = (Employee07) super.clone();

        // clone mutable fields
        cloned.hireDay = (Date) hireDay.clone();

        return cloned;
    }

    /**
     * Set the hire day to a given date.
     *
     * @param year  the year of the hire day
     * @param month the month of the hire day
     * @param day   the day of the hire day
     */
    public void setHireDay(int year, int month, int day) {
        Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();

        // Example of instance field mutation
        hireDay.setTime(newHireDay.getTime());
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    @Override
    public String toString() {
        return "Employee[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay + "]";
    }
}