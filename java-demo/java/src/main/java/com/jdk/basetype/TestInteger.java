package com.jdk.basetype;

public class TestInteger {

    public static void main(String[] args) {
        equalsInt();
    }

    /**
     * 跟int比较相等
     */
    public static void equalsInt(){
        Integer num1 = -1;
        int num2 = -1;
        int num3 = 2;
        System.out.println(num1 == num2);
        System.out.println(num1 == num3);
    }

    /**
     * 测试负数类型的Integer
     */
    public static void negativeInteger(){
        Integer num1 = -1;
        int num2 = -1;
        System.out.println(Integer.valueOf(num2).equals(num1));
    }
}
