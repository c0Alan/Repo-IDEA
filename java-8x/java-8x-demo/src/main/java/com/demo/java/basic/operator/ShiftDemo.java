package com.demo.java.basic.operator;

import org.junit.Test;

/**
 * 移位操作
 * 
 * @author liuxl
 * @date 2018/5/30 12:58
 */
public class ShiftDemo {

    /**
     * 计算 2 * 8
     * 效率很高
     */
    @Test
    public void cal2mul8(){
        int result = 2 << 3; // 2 * 2^3
        System.out.println(result);
    }
}
