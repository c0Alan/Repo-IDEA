package com.demo.java.io;

import com.demo.java.entity.Employee09;
import com.demo.java.entity.DataIO;

import java.io.*;
import java.time.LocalDate;

/**
 * RandomAccessFile 示例
 *
 * @author liuxl
 * @date 2024/5/3
 */
public class RandomAccessFileDemo {


    /**
     * 保存对象到文件，将文件转换为对象
     */
    public void test01() throws IOException {
        Employee09[] staff = new Employee09[3];

        staff[0] = new Employee09("Carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee09("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee09("Tony Tester", 40000, 1990, 3, 15);

        // idea路径: ${project}/employee.dat
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream("employee.dat"))) {
            // save all employee records to the file employee.dat
            for (Employee09 e : staff) {
               writeData(out, e);
            }
        }

        // idea路径: ${project}/employee.dat
        try (RandomAccessFile in = new RandomAccessFile("employee.dat", "r")) {
            // retrieve all records into a new array

            // compute the array size
            int n = (int) (in.length() / Employee09.RECORD_SIZE);
            Employee09[] newStaff = new Employee09[n];

            // read employees in reverse order
            for (int i = n - 1; i >= 0; i--) {
                newStaff[i] = new Employee09();
                in.seek(i * Employee09.RECORD_SIZE);
                newStaff[i] = readData(in);
            }

            // print the newly read employee records
            for (Employee09 e : newStaff) {
               System.out.println(e);
            }
        }
    }

    /**
     * Writes employee data to a data output
     *
     * @param out the data output
     * @param e   the employee
     */
    public static void writeData(DataOutput out, Employee09 e) throws IOException {
        DataIO.writeFixedString(e.getName(), Employee09.NAME_SIZE, out);
        out.writeDouble(e.getSalary());

        LocalDate hireDay = e.getHireDay();
        out.writeInt(hireDay.getYear());
        out.writeInt(hireDay.getMonthValue());
        out.writeInt(hireDay.getDayOfMonth());
    }

    /**
     * Reads employee data from a data input
     *
     * @param in the data input
     * @return the employee
     */
    public static Employee09 readData(DataInput in) throws IOException {
        String name = DataIO.readFixedString(Employee09.NAME_SIZE, in);
        double salary = in.readDouble();
        int y = in.readInt();
        int m = in.readInt();
        int d = in.readInt();
        return new Employee09(name, salary, y, m - 1, d);
    }
}
