package com.jdk.collection;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组测试
 * 
 * @author liuxilin
 * @date 2018/5/9 8:05
 */
public class ArrayDemo {
    private static Logger logger = Logger.getLogger(ArrayDemo.class);

    /**
     * 数组转列表
     */
    @Test
    public void asList(){
        Integer[] arr1 = {1, 2, 3};
        logger.info(Arrays.asList(arr1)); // [1, 2, 3]

        int[] arr2 = {1, 2, 3};
        logger.info(Arrays.asList(arr2)); // 不能把基本数据类型转化为列表, [[I@71dac704]

        ArrayList al = new ArrayList();
        al.add(1);
        al.add(2);
        logger.info(al); // [1, 2]
    }

}
