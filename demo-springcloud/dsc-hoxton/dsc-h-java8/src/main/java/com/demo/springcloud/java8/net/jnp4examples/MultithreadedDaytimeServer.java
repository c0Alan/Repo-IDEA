package com.demo.springcloud.java8.net.jnp4examples;

import java.net.*;
import java.io.*;
import java.util.Date;
 
public class MultithreadedDaytimeServer {
 
  public final static int PORT = 13;

  public static void main(String[] args) {   
   try (ServerSocket server = new ServerSocket(PORT)) {
     while (true) {  
       try {
         Socket connection = server.accept();
         Thread task = new DaytimeThread(connection);
         task.start();
       } catch (IOException ex) {}
     } 
    } catch (IOException ex) {
      System.err.println("Couldn't start server");
    }
  }
  
  private static class DaytimeThread extends Thread {
    
    private Socket connection;
    
    DaytimeThread(Socket connection) {
      this.connection = connection;
    }
    
    @Override
    public void run() {
      try {
        Writer out = new OutputStreamWriter(connection.getOutputStream());
        Date now = new Date();
        out.write(now.toString() +"\r\n");
        out.flush(); 
      } catch (IOException ex) {
        System.err.println(ex);
      } finally {
        try {
          connection.close();
        } catch (IOException e) {
          // ignore;
        }
      }
    }
  }
}