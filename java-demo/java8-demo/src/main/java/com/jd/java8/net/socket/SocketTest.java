package com.jd.java8.net.socket;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * socket 连接示例
 *
 * @author liuxilin
 * @date 2022/8/10 22:28
 */
public class SocketTest {
    public static void main(String[] args) throws IOException {
        try (Socket s = new Socket("time-a.nist.gov", 13);
             Scanner in = new Scanner(s.getInputStream(), "UTF-8")) {
            while (in.hasNextLine()) {
                String line = in.nextLine();
                System.out.println(line);
            }
        }
    }
}
