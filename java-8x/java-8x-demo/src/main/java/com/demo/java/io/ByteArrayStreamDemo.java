package com.demo.java.io;

import com.demo.java.entity.Employee11;
import org.junit.Test;

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




