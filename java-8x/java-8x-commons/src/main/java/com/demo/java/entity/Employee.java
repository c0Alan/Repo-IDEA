package com.demo.java.entity;


import java.time.LocalDate;

public class Employee extends AbstractPerson {
    private double salary;
    private LocalDate hireDay;

    public Employee() {
        super("super");
    }

    public Employee(String name, double salary, int year, int month, int day) {
        super(name);
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setHireDay(int year, int month, int day) {
        hireDay = LocalDate.of(year, month, day);
    }

    @Override
    public String getDescription() {
        return String.format("an employee with a salary of $%.2f", salary);
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}
