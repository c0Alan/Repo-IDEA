package com.jd.java8.net.jnp4examples;

import java.io.*;

public class SafeBufferedReader extends BufferedReader {

  public SafeBufferedReader(Reader in) {
    super(in);
  }

 /* public SafeBufferedReader(Reader in, int bufferSize) {
    super(in, bufferSize);
  }*/

  private boolean lookingForLineFeed = false;
  
  @Override 
  public int read() throws IOException {
    int c = super.read();
    if (c == '\n') {
      if (lookingForLineFeed) {
        lookingForLineFeed = false;
        return super.read();
      } else {
        return c;
      }
    } else if (c == '\r') {
      lookingForLineFeed = true;
      return c;
    } else {
      lookingForLineFeed = false;
      return c;
    }
  }
  
  
  public String readLine() throws IOException {
    StringBuilder sb = new StringBuilder("");
    while (true) {
      int c = super.read();
      if (c == -1) { // end of stream
        if (sb.length() == 0) return null;
        return sb.toString();
      } else if (c == '\n') {
        if (lookingForLineFeed) {
          lookingForLineFeed = false;
          continue;
        } else {
          return sb.toString();
        }
      } else if (c == '\r') {
        lookingForLineFeed = true;
        return sb.toString();
      } else {
        lookingForLineFeed = false;
        sb.append((char) c);
      }
    }
  }
}