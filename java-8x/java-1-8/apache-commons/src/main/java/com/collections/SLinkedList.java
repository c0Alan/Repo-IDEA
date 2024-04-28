package com.collections;

import java.util.NoSuchElementException;

/**
 * @author SUNHAN
 * @Date: 2014年9月29日
 */
public class SLinkedList {
    private transient int size = 0;
    private transient Node head = new Node(null, null, null);//用头结点来表示整个链表

    public SLinkedList() {//默认构造方法
        head.next = head;
        head.previous = head;
    }

    public void add(Object element) {//在末尾插入元素
        Node Nnode = new Node(element, head, head.previous);
        Nnode.previous.next = Nnode;
        Nnode.next.previous = Nnode;
        size++;
    }

    public void addBefore(Object o, Node e) {
        Node newNode = new Node(o, e, e.previous);
        newNode.previous.next = newNode;
        newNode.next.previous = newNode;
        size++;

    }

    public void add(int index, Object o) {//俩参数的add()方法
        addBefore(o, (index == size ? head : node(index)));
    }

    private Node node(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node e = head;//从header开始循环
        if (index < size / 2) {
            for (int i = 0; i <= index; i++) {//对用户而言，头结点是不可见的
                e = e.next;
            }
        } else {
            for (int i = size; i > index; i--) {
                e = e.previous;
            }
        }
        return e;
    }

    public Object remove(int index) {
        Node e = node(index);
        remove(e);
        return e.element;
    }

    private void remove(Node e) {
        if (e == head) {
            throw new NoSuchElementException();
        }
        e.previous.next = e.next;
        e.next.previous = e.previous;
        size--;
    }
}
