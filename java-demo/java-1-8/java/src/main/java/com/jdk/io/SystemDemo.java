package com.jdk.io;

import org.junit.Test;

public class SystemDemo {

    @Test
    public void getProperties(){
        System.out.println(System.getProperty("java.version")); // 1.8.0_152
        System.out.println(System.getProperty("user.dir")); // E:\01_Repos\***\java-demo\java
    }
}
