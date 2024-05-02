package com.demo.java.nio;

import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;
import java.net.*;

/**
 * 返回单个 HTML 页面的http模拟服务器
 *
 * @author liuxl
 * @date 2024/5/1
 */
public class Server03 {

    private ByteBuffer contentBuffer;
    private int port = 80;

    public Server03(ByteBuffer data, String encoding, String MIMEType, int port) {

        this.port = port;
        String header = "HTTP/1.0 200 OK\r\n"
                + "Server: NonblockingSingleFileHTTPServer\r\n"
                + "Content-length: " + data.limit() + "\r\n"
                + "Content-type: " + MIMEType + "\r\n\r\n";
        byte[] headerData = header.getBytes(Charset.forName("US-ASCII"));

        ByteBuffer buffer = ByteBuffer.allocate(data.limit() + headerData.length);
        buffer.put(headerData);
        buffer.put(data);
        buffer.flip();
        this.contentBuffer = buffer;
    }

    public void run() throws IOException {
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverChannel.socket();
        Selector selector = Selector.open();
        InetSocketAddress localPort = new InetSocketAddress(port);
        serverSocket.bind(localPort);
        serverChannel.configureBlocking(false);
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            selector.select();
            Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
            while (keys.hasNext()) {
                SelectionKey key = keys.next();
                keys.remove();
                try {
                    if (key.isAcceptable()) {
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();
                        SocketChannel channel = server.accept();
                        channel.configureBlocking(false);
                        channel.register(selector, SelectionKey.OP_READ);
                    } else if (key.isWritable()) {
                        SocketChannel channel = (SocketChannel) key.channel();
                        ByteBuffer buffer = (ByteBuffer) key.attachment();
                        if (buffer.hasRemaining()) {
                            channel.write(buffer);
                        } else { // we're done
                            channel.close();
                        }
                    } else if (key.isReadable()) {
                        // Don't bother trying to parse the HTTP header.
                        // Just read something.
                        SocketChannel channel = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(4096);
                        channel.read(buffer);
                        // switch channel to write-only mode
                        key.interestOps(SelectionKey.OP_WRITE);
                        key.attach(contentBuffer.duplicate());
                    }
                } catch (IOException ex) {
                    key.cancel();
                    try {
                        key.channel().close();
                    } catch (IOException cex) {
                    }
                }
            }
        }
    }

    /**
     * 在浏览器中访问 http://localhost:8080/ ，返回 index.html 内容
     * @param args
     */
    public static void main(String[] args) {

        try {
            // read the single file to serve
            String contentType = "text/html";
            String path = System.getProperty("user.dir");
            String fileName = path + "/" + "index.html";
            Path file = FileSystems.getDefault().getPath(fileName);
            byte[] data = Files.readAllBytes(file);
            ByteBuffer input = ByteBuffer.wrap(data);

            // set the port to listen on
            int port = 8080;

            String encoding = "UTF-8";
            Server03 server = new Server03(input, encoding, contentType, port);
            server.run();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}