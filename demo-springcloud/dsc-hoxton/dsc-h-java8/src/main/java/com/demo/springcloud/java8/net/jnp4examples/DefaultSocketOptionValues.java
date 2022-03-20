package com.demo.springcloud.java8.net.jnp4examples;

import java.io.IOException;
import java.net.SocketOption;
import java.nio.channels.DatagramChannel;

public class DefaultSocketOptionValues {

  public static void main(String[] args) {
    try (DatagramChannel channel = DatagramChannel.open()) {
      for (SocketOption<?> option : channel.supportedOptions()) {
        System.out.println(option.name() + ": " + channel.getOption(option));
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}