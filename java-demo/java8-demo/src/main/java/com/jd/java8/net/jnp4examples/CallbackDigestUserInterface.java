package com.jd.java8.net.jnp4examples;

import javax.xml.bind.*; // for DatatypeConverter; requires Java 6 or JAXB 1.0

public class CallbackDigestUserInterface {
  
  public static void receiveDigest(byte[] digest, String name) {
    StringBuilder result = new StringBuilder(name);
    result.append(": ");
    result.append(DatatypeConverter.printHexBinary(digest));
    System.out.println(result);
  }
  
  public static void main(String[] args) {
    for (String filename : args) {    
      // Calculate the digest
      CallbackDigest cb = new CallbackDigest(filename);
      Thread t = new Thread(cb);
      t.start();
    } 
  }
}