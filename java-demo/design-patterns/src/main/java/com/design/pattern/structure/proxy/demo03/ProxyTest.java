package com.design.pattern.structure.proxy.demo03;

public class ProxyTest {
  
    public static void main(String[] args) {  
        Sourceable source = new Proxy();  
        source.method();  
    }  
  
}