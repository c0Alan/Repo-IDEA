package com.demo.java.entity;

import java.time.LocalDate;

/**
 * The familiar Employee class, redefined to extend the
 * SerialCloneable class.
 */
public class Employee11 extends SerialCloneable {
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee11(String n, double s, int year, int month, int day) {
        name = n;
        salary = s;
        hireDay = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    /**
     * Raises the salary of this employee.
     *
     * @byPercent the percentage of the raise
     */
    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    @Override
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode())
                + "[name=" + name
                + ",salary=" + salary
                + ",hireDay=" + hireDay
                + "]";
    }
}