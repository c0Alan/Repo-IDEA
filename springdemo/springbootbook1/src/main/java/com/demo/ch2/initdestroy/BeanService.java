package com.demo.ch2.initdestroy;

public class BeanService {
    public void init(){
        System.out.println("BeanService inited");
    }

    public BeanService() {
        System.out.println("BeanService constructed");
    }

    public void destroy(){
        System.out.println("BeanService destroied");
    }
}
