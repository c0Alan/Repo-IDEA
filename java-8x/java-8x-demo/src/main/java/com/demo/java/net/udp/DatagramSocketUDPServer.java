package com.demo.java.net.udp;

import java.io.*;
import java.net.*;
import java.util.logging.*;

public abstract class DatagramSocketUDPServer implements Runnable {

    private final int bufferSize; // in bytes
    private final int port;
    private final Logger logger = Logger.getLogger(DatagramSocketUDPServer.class.getCanonicalName());
    private volatile boolean isShutDown = false;

    public DatagramSocketUDPServer(int port, int bufferSize) {
        this.bufferSize = bufferSize;
        this.port = port;
    }

    public DatagramSocketUDPServer(int port) {
        this(port, 8192);
    }

    @Override
    public void run() {
        byte[] buffer = new byte[bufferSize];
        try (DatagramSocket socket = new DatagramSocket(port)) {
            socket.setSoTimeout(10000); // check every 10 seconds for shutdown
            while (true) {
                if (isShutDown) {
                    return;
                }
                DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
                try {
                    socket.receive(incoming);
                    this.respond(socket, incoming);
                } catch (SocketTimeoutException ex) {
                    if (isShutDown) {
                        return;
                    }
                } catch (IOException ex) {
                    logger.log(Level.WARNING, ex.getMessage(), ex);
                }
            } // end while
        } catch (SocketException ex) {
            logger.log(Level.SEVERE, "Could not bind to port: " + port, ex);
        }
    }

    public abstract void respond(DatagramSocket socket, DatagramPacket request)
            throws IOException;

    public void shutDown() {
        this.isShutDown = true;
    }

}