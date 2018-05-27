package com.jvm.jvmstack;

public class JvmStackDemo01 {

    public static void main(String[] args) {
        test04();
    }

    public static void test01(){
        byte[] placeholder = new byte[64 * 1024 * 1024];
        System.gc();
    }

    public static void test02(){
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }
        System.gc();
    }

    public static void test03(){
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }
        int a = 0;
        System.gc();
    }

    /**
     * 编译时报错, a 未初始化
     */
    public static void test04(){
//        int a;
//        System.out.println(a);
    }

}
