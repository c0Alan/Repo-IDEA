package com.demo.java.io;

import com.demo.java.entity.SerialCloneable;
import org.junit.Test;

import java.time.LocalDate;

/**
 * ByteArrayInputStream、ByteArrayOutputStream 示例
 *
 * @author liuxilin
 * @date 2022/8/6 21:41
 */
public class ByteArrayStreamDemo {
    public static void main(String[] args) throws CloneNotSupportedException {

    }

    /**
     * 通过对象流实现深拷贝
     */
    @Test
    public void test01() throws CloneNotSupportedException {
        Employee11 harry = new Employee11("Harry Hacker", 35000, 1989, 10, 1);
        // clone harry
        Employee11 harry2 = (Employee11) harry.clone();

        // mutate harry
        harry.raiseSalary(10);

        // now harry and the clone are different
        System.out.println(harry);
        System.out.println(harry2);
    }


}

class Employee11 extends SerialCloneable {
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




