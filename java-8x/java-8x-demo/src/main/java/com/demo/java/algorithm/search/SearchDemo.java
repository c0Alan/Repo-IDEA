package com.demo.java.algorithm.search;

public class SearchDemo {


    /**
     * 在有序整型数组上的折半查找算法的实现
     *
     * @param s 有序数组
     * @param low
     * @param high
     * @param key
     * @return
     */
    public int binSearch(int[] s, int low, int high, int key) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (s[mid] == key) return mid;
            else if (s[mid] > key) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
}
