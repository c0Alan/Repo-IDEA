package com.demo.java.io;

import com.demo.java.entity.Employee09;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * PrintWriter 示例
 *
 * @author liuxilin
 * @date 2022/8/6 17:15
 */
public class PrintWriterDemo {


    public static void main(String[] args) throws IOException {}


    /**
     * 将对象写到文件中，并读取回jvm中
     */
    @Test
    public void test01() throws IOException {
        Employee09[] staff = new Employee09[3];

        staff[0] = new Employee09("Carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee09("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee09("Tony Tester", 40000, 1990, 3, 15);

        // idea路径: ${project}/employee.dat
        try (PrintWriter out = new PrintWriter("employee.dat", "UTF-8")) {
            writeData(staff, out);
        }

        // idea路径: ${project}/employee.dat
        try (Scanner in = new Scanner(new FileInputStream("employee.dat"), "UTF-8")) {
            Employee09[] newStaff = readData(in);

            // print the newly read employee records
            for (Employee09 e : newStaff) {
                System.out.println(e);
            }
        }
    }

    /**
     * Writes all employees in an array to a print writer
     *
     * @param employees an array of employees
     * @param out       a print writer
     */
    private static void writeData(Employee09[] employees, PrintWriter out) throws IOException {
        // write number of employees
        out.println(employees.length);

        for (Employee09 e : employees) {
            writeEmployee(out, e);
        }
    }

    /**
     * Reads an array of employees from a scanner
     *
     * @param in the scanner
     * @return the array of employees
     */
    private static Employee09[] readData(Scanner in) {
        // retrieve the array size
        int n = in.nextInt();
        in.nextLine(); // consume newline

        Employee09[] employees = new Employee09[n];
        for (int i = 0; i < n; i++) {
            employees[i] = readEmployee(in);
        }
        return employees;
    }

    /**
     * Writes employee data to a print writer
     *
     * @param out the print writer
     */
    public static void writeEmployee(PrintWriter out, Employee09 e) {
        out.println(e.getName() + "|" + e.getSalary() + "|" + e.getHireDay());
    }

    /**
     * Reads employee data from a buffered reader
     *
     * @param in the scanner
     */
    public static Employee09 readEmployee(Scanner in) {
        String line = in.nextLine();
        String[] tokens = line.split("\\|");
        String name = tokens[0];
        double salary = Double.parseDouble(tokens[1]);
        LocalDate hireDate = LocalDate.parse(tokens[2]);
        int year = hireDate.getYear();
        int month = hireDate.getMonthValue();
        int day = hireDate.getDayOfMonth();
        return new Employee09(name, salary, year, month, day);
    }
}
