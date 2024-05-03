package com.demo.java.io;

import com.demo.java.entity.Employee10;

import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;
import java.util.*;

/**
 * @author Cay Horstmann
 * @version 1.12 2012-05-30
 */
public class ByteBufferDemo {
    public static void main(String[] args) throws IOException {
        Employee10[] staff = new Employee10[3];

        staff[0] = new Employee10("Carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee10("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee10("Tony Tester", 40000, 1990, 3, 15);

        Path path = Paths.get("employee.dat");
        ByteBuffer buffer = ByteBuffer.allocate(Employee10.RECORD_SIZE);

        try (FileChannel channel = FileChannel.open(path,
                StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING)) {
            // save all employee records to the file employee.dat
            for (Employee10 e : staff) {
                buffer.clear();
                writeData(buffer, e);
                buffer.flip();
                channel.write(buffer);
            }
        }

        try (FileChannel channel = FileChannel.open(path, StandardOpenOption.READ)) {
            // compute the array size
            int n = (int) (Files.size(path)) / Employee10.RECORD_SIZE;
            Employee10[] newStaff = new Employee10[n];

            // read employees in reverse order
            for (int i = n - 1; i >= 0; i--) {
                newStaff[i] = new Employee10();
                channel.position(i * Employee10.RECORD_SIZE);
                buffer.clear();
                channel.read(buffer);
                buffer.flip();
                newStaff[i] = readData(buffer);
            }

            // print the newly read employee records
            for (Employee10 e : newStaff) {
                System.out.println(e);
            }
        }
    }


    /**
     * Writes employee data to a byte buffer
     *
     * @param out the buffer
     * @param e   the employee
     */
    public static void writeData(ByteBuffer out, Employee10 e) throws IOException {
        String name = e.getName();
        int length = Math.min(name.length(), Employee10.NAME_SIZE - 1);
        // for (int i = 0; i < length; i++) out.putChar(name.charAt(i));
        out.asCharBuffer().put(name.substring(0, length)).put('\0');
        out.position(2 * Employee10.NAME_SIZE);
        out.putDouble(e.getSalary());
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(e.getHireDay());
        out.putInt(calendar.get(Calendar.YEAR));
        out.putInt(calendar.get(Calendar.MONTH) + 1);
        out.putInt(calendar.get(Calendar.DAY_OF_MONTH));
    }

    /**
     * Reads employee data from a byte buffer
     *
     * @param in the buffer
     * @return the employee
     */
    public static Employee10 readData(ByteBuffer in) throws IOException {
        StringBuilder name = new StringBuilder();
        char ch;
        while ((ch = in.getChar()) != '\0') {
            name.append(ch);
        }
        in.position(2 * Employee10.NAME_SIZE);
        double salary = in.getDouble();
        int y = in.getInt();
        int m = in.getInt();
        int d = in.getInt();
        return new Employee10(name.toString(), salary, y, m - 1, d);
    }
}