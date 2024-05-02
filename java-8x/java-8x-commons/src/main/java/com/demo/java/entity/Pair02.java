package com.demo.java.entity;

/**
 * @author Cay Horstmann
 * @version 1.00 2004-05-10
 */
public class Pair02<T> {
    private T first;
    private T second;

    public Pair02() {
        first = null;
        second = null;
    }

    public Pair02(T first, T second) {
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
