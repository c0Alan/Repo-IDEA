package com.demo.java.io;

import com.demo.java.entity.Employee11;
import org.junit.Test;

import java.io.*;

/**
 * ByteArrayInputStream、ByteArrayOutputStream 示例
 *
 * @author liuxilin
 * @date 2022/8/6 21:41
 */
public class ByteArrayInputStreamDemo {
    public static void main(String[] args) throws CloneNotSupportedException {

    }

    /**
     * 通过对象流实现深拷贝
     */
    @Test
    public void test01() throws CloneNotSupportedException {
        Employee11 harry = new Employee11("Harry Hacker", 35000, 1989, 10, 1);
        // clone harry
        Employee11 harry2 = (Employee11) clone(harry);
        harry2.setName("harry2");

        // mutate harry
        harry.raiseSalary(10);

        // now harry and the clone are different
        System.out.println(harry);
        System.out.println(harry2);
    }

    public Object clone(Object obj) throws CloneNotSupportedException {
        try {
            // save the object to a byte array
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            try (ObjectOutputStream out = new ObjectOutputStream(bout)) {
                out.writeObject(obj);
            }

            // read a clone of the object from the byte array
            try (InputStream bin = new ByteArrayInputStream(bout.toByteArray())) {
                ObjectInputStream in = new ObjectInputStream(bin);
                return in.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            CloneNotSupportedException e2 = new CloneNotSupportedException();
            e2.initCause(e);
            throw e2;
        }
    }


}






