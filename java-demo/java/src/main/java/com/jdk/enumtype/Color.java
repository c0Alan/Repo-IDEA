package com.jdk.enumtype;


/**
 * 用法一：常量
 *
 * @author liuxl
 * @date 2018/4/7 9:20
 */
public enum Color {
    RED, GREEN, BLANK, YELLOW
}

class TestColor {
    public static void main(String[] args) {
        System.out.println(Color.RED.equals("red")); // false
        System.out.println(Color.RED.equals("RED")); // false
        System.out.println(Color.RED.toString().equals("red")); // false
        System.out.println(Color.RED.toString().equals("RED")); // true

        // IllegalArgumentException: No enum constant com.jdk.enumtype.Color.red
//        System.out.println(Enum.valueOf(Color.class, "red"));
        System.out.println(Enum.valueOf(Color.class, "RED")); // RED

        // IllegalArgumentException: No enum constant com.jdk.enumtype.Color.abc
        System.out.println(Enum.valueOf(Color.class, "abc"));
    }
}