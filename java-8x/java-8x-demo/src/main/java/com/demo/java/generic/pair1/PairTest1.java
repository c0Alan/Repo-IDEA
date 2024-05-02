package com.demo.java.generic.pair1;

/**
 * @author Cay Horstmann
 * @version 1.01 2012-01-26
 */
public class PairTest1 {

    /**
     * 打印最大最小值
     * @param args
     */
    public static void main(String[] args) {
        String[] words = {"Mary", "had", "a", "little", "lamb"};
        Pair<String> mm = ArrayAlg.minmax(words);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
    }
}


