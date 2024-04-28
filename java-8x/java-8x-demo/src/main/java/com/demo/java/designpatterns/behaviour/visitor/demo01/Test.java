package com.demo.java.designpatterns.behaviour.visitor.demo01;

public class Test {
  
    public static void main(String[] args) {  
          
        Visitor visitor = new MyVisitor();  
        Subject sub = new MySubject();  
        sub.accept(visitor);      
    }  
} 