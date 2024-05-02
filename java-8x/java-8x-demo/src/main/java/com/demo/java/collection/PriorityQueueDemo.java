package com.demo.java.collection;


import java.time.LocalDate;
import java.util.PriorityQueue;

/**
 * PriorityQueue 无序存储, 有序删除, 删除时按顺序从最低优先级删除
 *
 * @author liuxilin
 * @date 2022/7/2 17:06
 */
public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<LocalDate> pq = new PriorityQueue<>();
        // G. Hopper
        pq.add(LocalDate.of(1906, 12, 9));
        // A. Lovelace
        pq.add(LocalDate.of(1815, 12, 10));
        // J. von Neumann
        pq.add(LocalDate.of(1903, 12, 3));
        // K. Zuse
        pq.add(LocalDate.of(1910, 6, 22));

        System.out.println("Iterating over elements...");
        for (LocalDate date : pq) {
           System.out.println(date);
        }
        System.out.println("Removing elements...");
        while (!pq.isEmpty()) {
           System.out.println(pq.remove());
        }
    }
}
