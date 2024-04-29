package com.demo.java.designpatterns.behaviour.visitor;

public interface Subject {
    public void accept(Visitor visitor);  
    public String getSubject();  
} 