package com.demo.java.net.old.socket.server;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * ServerSocket(服务器套接字) 示例
 *
 * @author liuxilin
 * @date 2022/8/10 22:36
 */
public class EchoServer {
    public static void main(String[] args) throws IOException {
        // establish server socket
        try (ServerSocket s = new ServerSocket(8189)) {
            // wait for client connection
            try (Socket incoming = s.accept()) {
                InputStream inStream = incoming.getInputStream();
                OutputStream outStream = incoming.getOutputStream();

                try (Scanner in = new Scanner(inStream, "UTF-8")) {
                    PrintWriter out = new PrintWriter(
                            new OutputStreamWriter(outStream, "UTF-8"),
                            true /* autoFlush */);

                    out.println("Hello! Enter BYE to exit.");

                    // echo client input
                    boolean done = false;
                    while (!done && in.hasNextLine()) {
                        String line = in.nextLine();
                        out.println("Echo: " + line);
                        if (line.trim().equals("BYE")) {
                           done = true;
                        }
                    }
                }
            }
        }
    }
}