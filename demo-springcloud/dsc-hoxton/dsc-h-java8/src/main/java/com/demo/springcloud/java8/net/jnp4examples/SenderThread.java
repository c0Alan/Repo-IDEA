package com.demo.springcloud.java8.net.jnp4examples;

import java.io.*;
import java.net.*;

class SenderThread extends Thread {

  private InetAddress server;
  private DatagramSocket socket;
  private int port;
  private volatile boolean stopped = false;
  
  SenderThread(DatagramSocket socket, InetAddress address, int port) {
    this.server = address;
    this.port = port;
    this.socket = socket;
    this.socket.connect(server, port);
  }
  
  public void halt() {
    this.stopped = true; 
  }

  @Override
  public void run() {
    try {
      BufferedReader userInput 
          = new BufferedReader(new InputStreamReader(System.in));
      while (true) {
        if (stopped) return;
        String theLine = userInput.readLine();
        if (theLine.equals(".")) break;
        byte[] data = theLine.getBytes("UTF-8");
        DatagramPacket output 
            = new DatagramPacket(data, data.length, server, port);
        socket.send(output);
        Thread.yield();
      }
    } catch (IOException ex) {
      System.err.println(ex);
    }
  }
}