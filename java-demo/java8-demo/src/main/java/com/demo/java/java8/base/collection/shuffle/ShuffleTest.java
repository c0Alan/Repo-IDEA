package com.demo.java.java8.base.collection.shuffle;

import java.util.*;

/**
 * Collections.shuffle 混排方法, 即将排序随机打乱
 *
 * @author liuxilin
 * @date 2022/7/2 21:10
 */
public class ShuffleTest {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 49; i++) {
           numbers.add(i);
        }
        Collections.shuffle(numbers);
        List<Integer> winningCombination = numbers.subList(0, 6);
       System.out.println(winningCombination);
       Collections.sort(winningCombination);
        System.out.println(winningCombination);
    }
}
