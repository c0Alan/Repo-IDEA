package com.demo.java.net.basic.socket.client;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * 测试 sendUrgentData 客户端
 *
 * @author liuxilin
 * @date 2018/5/12 15:04
 */
public class SocketClient01 {

    /**
     * 使用 sendUrgentData 方法发送数据后，系统会立即将这些数据发送出去；
     * 而使用write发送数据，必须要使用flush方法才会真正发送数据
     * 发送'B'时实际发送的是322，由于sendUrgentData只发送整型数的低字节。因此，实际发送的是66
     * 服务器已经启动，端口号：1234
     * ABChello world
     * 中国
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 1234);

        // 打开SO_OOBINLINE选项时要注意是必须在客户端和服务端程序同时使用setOOBInline方法打开这个选项，
        // 否则无法命名用sendUrgentData来发送数据
        socket.setOOBInline(true);
        OutputStream out = socket.getOutputStream();
        OutputStreamWriter outWriter = new OutputStreamWriter(out);
        outWriter.write(67);              // 向服务器发送字符"C"
        outWriter.write("hello world\r\n");
        socket.sendUrgentData(65);        // 向服务器发送字符"A"
        socket.sendUrgentData(322);        // 向服务器发送字符"B"
        outWriter.flush();
        socket.sendUrgentData(214);       // 向服务器发送汉字”中”
        socket.sendUrgentData(208);
        socket.sendUrgentData(185);       // 向服务器发送汉字”国”
        socket.sendUrgentData(250);
        socket.close();
    }
}
