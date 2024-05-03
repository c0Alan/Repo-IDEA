package com.demo.java.entity;

public class Manager04 extends Employee08 {
    private Employee08 secretary;

    /**
     * Constructs a Manager without a secretary
     *
     * @param n     the employee's name
     * @param s     the salary
     * @param year  the hire year
     * @param month the hire month
     * @param day   the hire day
     */
    public Manager04(String n, double s, int year, int month, int day) {
        super(n, s, year, month, day);
        secretary = null;
    }

    /**
     * Assigns a secretary to the manager.
     *
     * @param s the secretary
     */
    public void setSecretary(Employee08 s) {
        secretary = s;
    }

    @Override
    public String toString() {
        return super.toString() + "[secretary=" + secretary + "]";
    }
}
