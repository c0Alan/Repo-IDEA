package com.algorithm.recursion;

/**
 * 分治法
 * 
 * @author liuxilin
 * @date 2018/5/29 22:26
 */
public class Recursion02 {

    public static void main(String[] args) {
        Recursion02 r = new Recursion02();
        int[] a = {1, 3, 6, 8, 2, 4, 10, 9, 11, 23, 7, 5};
        IntPair ip = r.simpleMinMax(a);
        System.out.println("Max=" + ip.x + " Min=" + ip.y);
        ip = r.min_max(a, 0, a.length - 1);
        System.out.println("Max=" + ip.x + " Min=" + ip.y);
        System.out.println("The k=8 is: " + r.selectK(a, a.length, 8));
    }

    /**
     * 归纳法的实现, 寻找具有n 个元素的数组a[0, n-1]中的最大与最小元素。
     * @param a
     * @return
     */
    public IntPair simpleMinMax(int[] a) {
        IntPair pair = new IntPair();
        pair.x = a[0];
        pair.y = a[0];
        for (int i = 1; i < a.length; i++) {
            if (pair.x < a[i]) pair.x = a[i];
            if (pair.y > a[i]) pair.y = a[i];
        }
        return pair;
    }

    /**
     * 分治法的实现, 寻找具有n 个元素的数组a[0, n-1]中的最大与最小元素。
     * 二分查找
     *
     * @author liuxilin
     * @date 2018/5/29 22:31
     */
    public IntPair min_max(int[] a, int low, int high) {
        IntPair pair = new IntPair();
        if (low > high - 2) {
            if (a[low] < a[high]) {
                pair.x = a[high];
                pair.y = a[low];
            } else {
                pair.y = a[high];
                pair.x = a[low];
            }
        } else {
            int mid = (low + high) / 2;
            IntPair p1 = min_max(a, low, mid);
            IntPair p2 = min_max(a, mid + 1, high);
            pair.x = p1.x > p2.x ? p1.x : p2.x;
            pair.y = p1.y < p2.y ? p1.y : p2.y;
        }
        return pair;
    }

    /**
     * 寻找数组中第 k 小元素
     * 看不懂, 太 tm 高级了
     * @param a
     * @param n
     * @param k
     * @return
     */
    public int selectK(int[] a, int n, int k) {
        if (n < 10) {
            mergeSort(a, 0, a.length - 1);    //使用归并排序直接对数组a排序
            return a[k - 1];
        }
        int[] m = new int[n / 5];
        for (int i = 0; i < n / 5; i++) {
            m[i] = mid(a, 5 * i, 5 * i + 4);
        }
        int mm = selectK(m, m.length, (m.length + 1) / 2);
        int[] a1 = new int[3 * n / 4];
        int[] a3 = new int[3 * n / 4];
        int r = 0, s = 0, t = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] < mm) {
                a1[r++] = a[i];
                continue;
            }
            if (a[i] == mm) {
                s++;
                continue;
            }
            if (a[i] > mm) {
                a3[t++] = a[i];
                continue;
            }
        }
        if (k <= r) return selectK(a1, r, k);
        else if (k <= r + s) return mm;
        else return selectK(a3, t, k - r - s);
    }

    public void mergeSort(int[] a, int low, int high) {
        if (high - low < 2) {
            if (a[low] > a[high]) {
                int temp = a[low];
                a[low] = a[high];
                a[high] = temp;
            }
            return;
        }
        mergeSort(a, low, (high + low) / 2);
        mergeSort(a, (high + low) / 2 + 1, high);
        merge(a, low, (high + low) / 2, high);
    }

    public void merge(int[] a, int p, int q, int r) {
        int[] b = new int[r - p + 1];
        int s = p;
        int t = q + 1;
        int k = 0;
        while (s <= q && t <= r)
            if (a[s] < a[t]) b[k++] = a[s++];
            else b[k++] = a[t++];
        while (s <= q) b[k++] = a[s++];
        while (t <= r) b[k++] = a[t++];
        for (int i = 0; i < b.length; i++)
            a[p + i] = b[i];
    }

    private int mid(int[] a, int low, int high) {
        mergeSort(a, low, high);
        return a[(high - low) / 2];
    }

    private class IntPair {
        int x;
        int y;
    }
}
