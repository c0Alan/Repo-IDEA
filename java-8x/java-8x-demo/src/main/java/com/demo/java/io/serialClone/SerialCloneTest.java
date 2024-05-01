package com.demo.java.io.serialClone;

/**
 * 通过对象流实现深拷贝
 *
 * @author liuxilin
 * @date 2022/8/6 21:41
 */
public class SerialCloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employee harry = new Employee("Harry Hacker", 35000, 1989, 10, 1);
        // clone harry
        Employee harry2 = (Employee) harry.clone();

        // mutate harry
        harry.raiseSalary(10);

        // now harry and the clone are different
        System.out.println(harry);
        System.out.println(harry2);
    }
}




