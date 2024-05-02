package com.demo.java.collection;

import com.demo.java.entity.CircularArrayQueue;

import java.util.*;

/**
 * This program demonstrates how to extend the collections framework.
 *
 * @author Cay Horstmann
 * @version 1.21 2012-01-26
 */
public class CircularArrayQueueDemo {
    public static void main(String[] args) {
        Queue<String> q = new CircularArrayQueue<>(5);
        q.add("Amy");
        q.add("Bob");
        q.add("Carl");
        q.add("Deedee");
        q.add("Emile");
        q.remove();
        q.add("Fifi");
        q.remove();
        for (String s : q) {
            System.out.println(s);
        }
    }
}


