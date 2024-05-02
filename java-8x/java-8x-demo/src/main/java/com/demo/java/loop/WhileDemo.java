package com.demo.java.loop;

import java.util.Scanner;

/**
 * This program demonstrates a <code>while</code> loop.
 *
 * @author Cay Horstmann
 * @version 1.20 2004-02-10
 */
public class WhileDemo {
    public static void main(String[] args) {
        demo01();
    }

    /**
     * while (condition) statement 示例
     * 将计算需要多长时间才能够存储一定数量的退休金，假定每年存入相同数量的金额，而且利率是固定的
     */
    public static void demo01() {
        // read inputs
        Scanner in = new Scanner(System.in);

        System.out.print("How much money do you need to retire? ");
        double goal = in.nextDouble();

        System.out.print("How much money will you contribute every year? ");
        double payment = in.nextDouble();

        System.out.print("Interest rate in %: ");
        double interestRate = in.nextDouble();

        double balance = 0;
        int years = 0;

        // update account balance while goal isn't reached
        while (balance < goal) {
            // add this year's payment and interest
            balance += payment;
            double interest = balance * interestRate / 100;
            balance += interest;
            years++;
        }

        System.out.println("You can retire in " + years + " years.");
    }

    /**
     * do statement while (condition); 示例
     * 只要用户回答 “N”，循环就重复执行
     */
    public static void demo02() {
        Scanner in = new Scanner(System.in);

        System.out.print("How much money will you contribute every year? ");
        double payment = in.nextDouble();

        System.out.print("Interest rate in %: ");
        double interestRate = in.nextDouble();

        double balance = 0;
        int year = 0;

        String input;

        // update account balance while user isn't ready to retire
        do {
            // add this year's payment and interest
            balance += payment;
            double interest = balance * interestRate / 100;
            balance += interest;

            year++;

            // print current balance
            System.out.printf("After year %d, your balance is %,.2f%n", year, balance);

            // ask if ready to retire and get input
            System.out.print("Ready to retire? (Y/N) ");
            input = in.next();
        }
        while (input.equals("N"));
    }
}