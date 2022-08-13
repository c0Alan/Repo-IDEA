package com.demo.springcloud.java8.net.threaded;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This program implements a multithreaded server that listens to port 8189 and echoes back
 * all client input.
 *
 * @author Cay Horstmann
 * @version 1.22 2016-04-27
 */
public class ThreadedEchoServer {
    public static void main(String[] args) {
        try (ServerSocket s = new ServerSocket(8189)) {
            int i = 1;

            while (true) {
                Socket incoming = s.accept();
                System.out.println("Spawning " + i);
                Runnable r = new ThreadedEchoHandler(incoming);
                Thread t = new Thread(r);
                t.start();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


