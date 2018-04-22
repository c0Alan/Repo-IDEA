package com.collections;

public class Node {
    Object element;
    Node next;
    Node previous;

    public Node(Object element, Node next, Node previous) {
        this.element = element;
        this.next = next;
        this.previous = previous;
    }
}