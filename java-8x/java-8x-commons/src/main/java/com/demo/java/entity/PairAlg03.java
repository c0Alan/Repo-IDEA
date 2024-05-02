package com.demo.java.entity;

public class PairAlg03 {
    public static boolean hasNulls(Pair03<?> p) {
        return p.getFirst() == null || p.getSecond() == null;
    }

    public static void swap(Pair03<?> p) {
        swapHelper(p);
    }

    public static <T> void swapHelper(Pair03<T> p) {
        T t = p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
    }
}