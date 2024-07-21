package com.demo.java.apachecommons.net.app;

import com.net.ip.JInetAddress;
import com.demo.java.apachecommons.net.program.NetProgram;

/**
 * jdk 测试类入口
 * 
 * @author liuxl
 * 2017-9-27 下午4:59:56
 */
public class App { 
    
    public static JInetAddress inetAddress = new JInetAddress();
    public static NetProgram netProgram = new NetProgram();

    public static void main(String[] args) throws Exception {
        NetProgram.chapter02();
    }

}
