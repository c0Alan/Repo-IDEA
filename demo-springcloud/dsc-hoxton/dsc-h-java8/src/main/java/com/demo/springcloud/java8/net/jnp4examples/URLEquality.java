package com.demo.springcloud.java8.net.jnp4examples;

import java.net.*;

public class URLEquality {

  public static void main (String[] args) {
    try {
      URL www = new URL ("http://www.ibiblio.org/");
      URL ibiblio = new URL("http://ibiblio.org/");
      if (ibiblio.equals(www)) {
        System.out.println(ibiblio + " is the same as " + www);
      } else {
        System.out.println(ibiblio + " is not the same as " + www);
      }
    } catch (MalformedURLException ex) {
      System.err.println(ex);
    }
  }
}