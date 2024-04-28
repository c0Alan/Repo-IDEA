package com.demo.java.jdk.modifier.finals;

/**
 * 测试final修饰的属性跟入参
 * 
 * @author liuxl
 * @date 2018/6/11 12:26
 */
public class FinalDemo02 {
    private final int id = 1; // final 定义的属性必须初始化
    public static void main(String[] args) {
        int i = 0;
        add(i);
        System.out.println(i); // 0
    }

/*    public int add(final int x){
        return x++; // 这里报错, 无法修改final 修饰的入参
    }*/

    public static int add(int x){
        return x++;
    }

    public static int test(){
        final int aa; // final定义的局部变量可以再后面初始化
        aa = 1;
//        aa = 2; // 这里报错
        return aa;
    }
}
