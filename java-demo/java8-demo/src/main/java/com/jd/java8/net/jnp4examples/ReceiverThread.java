package com.jd.java8.net.jnp4examples;

import java.io.*;
import java.net.*;

class ReceiverThread extends Thread {

  private DatagramSocket socket;
  private volatile boolean stopped = false;

  ReceiverThread(DatagramSocket socket) {
    this.socket = socket;
  }

  public void halt() {
    this.stopped = true; 
  }

  @Override
  public void run() {
    byte[] buffer = new byte[65507];
    while (true) {
      if (stopped) return;
      DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
      try {
        socket.receive(dp);
        String s = new String(dp.getData(), 0, dp.getLength(), "UTF-8");
        System.out.println(s);
        Thread.yield();
      } catch (IOException ex) {
        System.err.println(ex);
      } 
    }  
  }
}