package com.demo.java.designpatterns.behaviour.chain;

/**
 * Chain 责任链模式是指一个链式调用模式，即多个对象都有机会处理请求，但只有其中一个对象可以处理，处理完请求后，不再继续往下传递，
 * 场景为链式处理场景，此处强调一点就是，链接上的请求可以是一条链，可以是一个树，还可以是一个环，模式本身不约束这个，需要我们自己去实现，同时，在一个时刻，命令只允许由一个对象传给另一个对象，而不允许传给多个对象。
 *
 * @author liuxl
 * @date 2024/4/29
 */
public class ChainDemo {
  
    public static void main(String[] args) {  
        MyHandler h1 = new MyHandler("h1");  
        MyHandler h2 = new MyHandler("h2");  
        MyHandler h3 = new MyHandler("h3");  
  
        h1.setHandler(h2);  
        h2.setHandler(h3);  
  
        h1.operator();  
    }  
} 