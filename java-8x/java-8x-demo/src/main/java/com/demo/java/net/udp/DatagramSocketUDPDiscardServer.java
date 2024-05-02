package com.demo.java.net.udp;

import java.io.UnsupportedEncodingException;
import java.net.*;

public class DatagramSocketUDPDiscardServer extends DatagramSocketUDPServer {

    public final static int DEFAULT_PORT = 9;

    public DatagramSocketUDPDiscardServer() {
        super(DEFAULT_PORT);
    }

    @Override
    public void respond(DatagramSocket socket, DatagramPacket request) throws UnsupportedEncodingException {
        String s = new String(request.getData(), 0, request.getLength(), "8859_1");
        System.out.println(request.getAddress() + " at port " + request.getPort() + " says " + s);
    }
}