package com.demo.springcloud.java8.base.interfaces;

import java.util.Arrays;

/**
 * 接口定义/实现示例
 *
 * @author liuxilin
 * @date 2022/6/25 16:44
 */
public class EmployeeSortTest {

    /**
     * 实现 Employee 对象按 salary 属性排序
     *
     * @param args
     */
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Harry Hacker", 35000);
        staff[1] = new Employee("Carl Cracker", 75000);
        staff[2] = new Employee("Tony Tester", 38000);

        Arrays.sort(staff);

        // print out information about all Employee objects
        for (Employee e : staff) {
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());
        }
    }
}