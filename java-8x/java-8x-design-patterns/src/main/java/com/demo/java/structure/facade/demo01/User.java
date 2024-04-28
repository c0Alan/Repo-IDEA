package com.demo.java.structure.facade.demo01;

public class User {
  
    public static void main(String[] args) {  
        Computer computer = new Computer();  
        computer.startup();  
        computer.shutdown();  
    }  
} 