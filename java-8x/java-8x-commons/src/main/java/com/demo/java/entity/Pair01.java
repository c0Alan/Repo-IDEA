package com.demo.java.entity;

/**
 * @author Cay Horstmann
 * @version 1.00 2004-05-10
 */
public class Pair01<T> {
    private T first;
    private T second;

    public Pair01() {
        first = null;
        second = null;
    }

    public Pair01(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(T newValue) {
        first = newValue;
    }

    public void setSecond(T newValue) {
        second = newValue;
    }
}
