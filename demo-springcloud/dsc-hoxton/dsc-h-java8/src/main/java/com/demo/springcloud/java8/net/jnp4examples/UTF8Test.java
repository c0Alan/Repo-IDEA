package com.demo.springcloud.java8.net.jnp4examples;

import java.io.UnsupportedEncodingException;


public class UTF8Test {

  public static void main(String[] args) throws UnsupportedEncodingException {
    String pi = "\u03C0";
    byte[] data = pi.getBytes("UTF-8");
    for (byte x : data) {
      System.out.println(Integer.toHexString(x));
    }
  }
  
}
