package com.demo.java.behaviour.visitor.demo01;

public interface Subject {
    public void accept(Visitor visitor);  
    public String getSubject();  
} 