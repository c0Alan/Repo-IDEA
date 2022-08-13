package com.demo.springcloud.java8.base.clazz.demo02;

/**
 * 静态域与静态方法
 *
 * @author Cay Horstmann
 * @version 1.01 2004-02-19
 */
public class StaticTest {
    public static void main(String[] args) {
        // fill the staff array with three Employee objects
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Tom", 40000);
        staff[1] = new Employee("Dick", 60000);
        staff[2] = new Employee("Harry", 65000);

        // print out information about all Employee objects
        for (Employee e : staff) {
            e.setId();
            System.out.println("name=" + e.getName() + ",id=" + e.getId() + ",salary="
                    + e.getSalary());
        }

        // calls static method
        int n = Employee.getNextId();
        System.out.println("Next available id=" + n);
    }
}