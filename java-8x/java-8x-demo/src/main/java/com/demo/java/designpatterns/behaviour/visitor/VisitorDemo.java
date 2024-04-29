package com.demo.java.designpatterns.behaviour.visitor;

/**
 * Visitor 访问者模式是指定一种作用于某对象结构中的各元素的操作，它可以在不改变各元素的前提下定义作用于这些元素的新操作。
 * 访问者模式适用于数据结构相对稳定的系统，把数据结构和算法解耦
 *
 * @author liuxl
 * @date 2024/4/29
 */
public class VisitorDemo {
  
    public static void main(String[] args) {  
          
        Visitor visitor = new MyVisitor();  
        Subject sub = new MySubject();  
        sub.accept(visitor);      
    }  
} 