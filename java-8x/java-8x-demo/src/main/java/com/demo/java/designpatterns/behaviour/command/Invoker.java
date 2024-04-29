package com.demo.java.designpatterns.behaviour.command;

public class Invoker {
      
    private Command command;  
      
    public Invoker(Command command) {  
        this.command = command;  
    }  
  
    public void invoke(){
        System.out.println("Invoker invoke command!");
        command.exe();  
    }  
}