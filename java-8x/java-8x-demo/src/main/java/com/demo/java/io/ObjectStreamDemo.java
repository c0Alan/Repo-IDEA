package com.demo.java.io;

import com.demo.java.entity.Employee08;
import com.demo.java.entity.Manager04;
import org.junit.Test;

import java.io.*;

/**
 * ObjectInputStream、ObjectOutputStream 示例
 *
 * @author liuxilin
 * @date 2022/8/6 20:17
 */
public class ObjectStreamDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectStreamDemo demo = new ObjectStreamDemo();
        demo.test01();
    }

    /**
     * 对象输入输出流
     */
    @Test
    public void test01() throws IOException, ClassNotFoundException {
        Employee08 harry = new Employee08("Harry Hacker", 50000, 1989, 10, 1);
        Manager04 carl = new Manager04("Carl Cracker", 80000, 1987, 12, 15);
        carl.setSecretary(harry);
        Manager04 tony = new Manager04("Tony Tester", 40000, 1990, 3, 15);
        tony.setSecretary(harry);

        Employee08[] staff = new Employee08[3];

        staff[0] = carl;
        staff[1] = harry;
        staff[2] = tony;

        // idea路径: ${project}/employee.dat
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.dat"))) {
            out.writeObject(staff);
        }

        // idea路径: ${project}/employee.dat
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.dat"))) {
            // retrieve all records into a new array

            Employee08[] newStaff = (Employee08[]) in.readObject();

            // raise secretary's salary
            newStaff[1].raiseSalary(10);

            // print the newly read employee records
            for (Employee08 e : newStaff) {
                System.out.println(e);
            }
        }
    }
}