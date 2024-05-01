package com.demo.java.net;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerSocketDemo {
    private static final Logger logger = Logger.getLogger(ServerSocketDemo.class.getCanonicalName());

    public static void main(String[] args) {
        ServerSocketDemo demo = new ServerSocketDemo();
        demo.test03();
    }

    /**
     * 模拟处理 HTTP 请求
     * telnet localhost 9099 , 输入 GET /index.html HTTP/1.1
     * telnet localhost 9099 , 输入 GET /index2.html HTTP/1.1
     */
    @Test
    public void test03() {

        // get the Document root
        String docRootDir = System.getProperty("user.dir");
        File docroot;
        try {
            docroot = new File(docRootDir);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Usage: java JHTTP docroot port");
            return;
        }

        // set the port to listen on
        int port = 9099;

        try {
            ServerSocketJHTTP webserver = new ServerSocketJHTTP(docroot, port);
            webserver.start();
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Server could not start", ex);
        }
    }

    /**
     * 使用线程池的 daytime 服务器
     */
    @Test
    public void test02() {

        int PORT = 13;

        ExecutorService pool = Executors.newFixedThreadPool(50);

        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                try {
                    Socket connection = server.accept();
                    Callable<Void> task = new DaytimeTask(connection);
                    pool.submit(task);
                } catch (IOException ex) {
                }
            }
        } catch (IOException ex) {
            System.err.println("Couldn't start server");
        }
    }

    private static class DaytimeTask implements Callable<Void> {
        private Socket connection;

        DaytimeTask(Socket connection) {
            this.connection = connection;
        }

        @Override
        public Void call() {
            try {
                Writer out = new OutputStreamWriter(connection.getOutputStream());
                Date now = new Date();
                out.write(now.toString() + "\r\n");
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
            return null;
        }
    }


    /**
     * 模拟创建daytime服务器
     * 使用telnet连接测试
     */
    @Test
    public void test01() {
        int port = 13;
        try (ServerSocket server = new ServerSocket(port)) {
            while (true) {
                try (Socket connection = server.accept()) {
                    System.out.println(connection.getRemoteSocketAddress() + "已连接...");
                    Writer out = new OutputStreamWriter(connection.getOutputStream());
                    Date now = new Date();
                    out.write(now.toString() + "\r\n");
                    out.flush();
                    connection.close();
                } catch (IOException ex) {
                    System.err.println(ex);
                }
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
} 