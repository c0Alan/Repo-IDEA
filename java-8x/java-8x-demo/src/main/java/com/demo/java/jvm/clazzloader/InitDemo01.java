package com.demo.java.jvm.clazzloader;

/**
 * 初始化实例
 * 
 * @author liuxilin
 * @date 2018/5/27 16:37
 */
public class InitDemo01 {
   /* static {
        i = 0;  //  给变量复制可以正常编译通过
        System.out.print(i);  // 这句编译器会提示“非法向前引用”, 应该放到说明下面
    }*/
    static int i = 1;
}