package com.demo.java.java8.util;

import java.util.Scanner;

/**
 * This program demonstrates console input.
 *
 * @author Cay Horstmann
 * @version 1.10 2004-02-10
 */
public class ScannerDemo {
    public static void main(String[] args) {
        demo01();
    }

    public static void demo01() {
        Scanner in = new Scanner(System.in);

        // get first input
        System.out.print("What is your name? ");
        String name = in.nextLine();

        // get second input
        System.out.print("How old are you? ");
        int age = in.nextInt();

        // display output on console
        System.out.println("Hello, " + name + ". Next year, you'll be " + (age + 1));
    }
}