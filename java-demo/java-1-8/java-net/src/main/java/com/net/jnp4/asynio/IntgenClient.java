package com.net.jnp4.asynio;

import java.nio.*;
import java.nio.channels.*;
import java.net.*;
import java.io.IOException;

public class IntgenClient {
    
  public static int DEFAULT_PORT = 1919;
  
  public static void main(String[] args) {
  
    if (args.length == 0) {
      System.out.println("Usage: java IntgenClient host [port]"); 
      return;
    }  
  
    int port;
    try {
      port = Integer.parseInt(args[1]);
    } catch (RuntimeException ex) {
      port = DEFAULT_PORT;   
    }
    
    try {
      SocketAddress address = new InetSocketAddress(args[0], port);
      SocketChannel client  = SocketChannel.open(address);
      ByteBuffer    buffer  = ByteBuffer.allocate(4);
      IntBuffer     view    = buffer.asIntBuffer();
      
      for (int expected = 0; ; expected++) {
        client.read(buffer);
        int actual = view.get();
        buffer.clear();
        view.rewind();
        
        if (actual != expected) {
          System.err.println("Expected " + expected + "; was " + actual);
          break;
        }
        System.out.println(actual);
      }     
    } catch(IOException ex) {
      ex.printStackTrace();   
    }
  }
}