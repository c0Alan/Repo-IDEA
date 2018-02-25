package com.demo.ch2.initdestroy;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class JSR250Service {

    @PostConstruct
    public void init(){
        System.out.println("JSR250Service inited");
    }

    public JSR250Service() {
        System.out.println("JSR250Service constructed");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("JSR250Service destroied");
    }

}
