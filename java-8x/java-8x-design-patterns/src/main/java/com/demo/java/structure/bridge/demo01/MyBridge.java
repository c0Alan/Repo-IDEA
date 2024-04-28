package com.demo.java.structure.bridge.demo01;

public class MyBridge extends Bridge {
    public void method(){  
        getSource().method();  
    }  
}  