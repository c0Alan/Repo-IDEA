package com.demo.springcloud.java8.net.jnp4examples;

import java.io.*;
import java.security.*;

public class CallbackDigest implements Runnable {

  private String filename;

  public CallbackDigest(String filename) {
   this.filename = filename;
  }

  @Override
  public void run() {
    try {
      FileInputStream in = new FileInputStream(filename);
      MessageDigest sha = MessageDigest.getInstance("SHA-256");
      DigestInputStream din = new DigestInputStream(in, sha);
      while (din.read() != -1) ; // read entire file
      din.close();
      byte[] digest = sha.digest();
      CallbackDigestUserInterface.receiveDigest(digest, filename);
    } catch (IOException ex) {
      System.err.println(ex);
    } catch (NoSuchAlgorithmException ex) {
      System.err.println(ex);
    }
  }
}