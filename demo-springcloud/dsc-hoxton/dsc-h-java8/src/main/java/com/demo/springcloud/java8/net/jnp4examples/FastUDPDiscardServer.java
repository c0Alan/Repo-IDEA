package com.demo.springcloud.java8.net.jnp4examples;

import java.net.*;

public class FastUDPDiscardServer extends UDPServer {

  public final static int DEFAULT_PORT = 9;
  
  public FastUDPDiscardServer() {
    super(DEFAULT_PORT);
  }
  
  public static void main(String[] args) {
    UDPServer server = new FastUDPDiscardServer();
    Thread t = new Thread(server);
    t.start();
  }

  @Override
  public void respond(DatagramSocket socket, DatagramPacket request) {
  }
}