package com.demo.java.entity;

public class ArrayAlg01 {
    /**
     * Gets the minimum and maximum of an array of strings.
     *
     * @param a an array of strings
     * @return a pair with the min and max value, or null if a is null or empty
     */
    public static Pair01<String> minmax(String[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        String min = a[0];
        String max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) {
                min = a[i];
            }
            if (max.compareTo(a[i]) < 0) {
                max = a[i];
            }
        }
        return new Pair01<>(min, max);
    }
}