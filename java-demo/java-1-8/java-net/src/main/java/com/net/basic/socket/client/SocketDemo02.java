package com.net.basic.socket.client;

import org.junit.Test;

import java.io.*;
import java.net.Socket;

/**
 *
 * 
 * @author liuxilin
 * @date 2018/5/12 8:48
 */
public class SocketDemo02 {

    /**
     * 发送和接收数据
     */
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("www.baidu.com", 80);
        // 向服务端程序发送数据
        OutputStream ops  = socket.getOutputStream();
        OutputStreamWriter opsw = new OutputStreamWriter(ops);
        BufferedWriter bw = new BufferedWriter(opsw);

        bw.write("hello world\r\n\r\n");
        bw.flush();

        // 从服务端程序接收数据
        InputStream ips = socket.getInputStream();
        InputStreamReader ipsr = new InputStreamReader(ips);
        BufferedReader br = new BufferedReader(ipsr);
        String s = "";
        while((s = br.readLine()) != null)
            System.out.println(s);
        socket.close();
    }
}
