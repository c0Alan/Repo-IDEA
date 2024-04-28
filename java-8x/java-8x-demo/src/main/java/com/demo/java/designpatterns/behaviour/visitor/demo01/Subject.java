package com.demo.java.designpatterns.behaviour.visitor.demo01;

public interface Subject {
    public void accept(Visitor visitor);  
    public String getSubject();  
} 