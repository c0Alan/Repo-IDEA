package com.net.basic.ssh;

import ch.ethz.ssh2.ChannelCondition;
import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author liuxilin
 * @version 2018/9/17
 * @Copyright (C)2018 , Suntektech
 * @since
 */
public class SSHTest {
    public static void main(String[] args) throws Exception {
        test2();
    }

    public static void test1() throws IOException {
        String ipAddr = "172.25.20.133";
        String userName = "root";
        String password = "Suntek123";

//        a) 连接：
        Connection conn = new Connection(ipAddr);
        conn.connect();

//        b)认证：
        boolean authenticateVal = conn.authenticateWithPassword(userName, password);

//        c) 打开一个Session:
        Session session = null;
        if (authenticateVal) {
            session = conn.openSession();
        }

//        d) 执行Shell命令：
//        1）若是执行简单的Shell命令：（如 jps 、last 这样的命令 ）
        String cmd = "rm -f /opt/aos/test.txt";
        session.execCommand(cmd);
    }

    public static void test2() throws IOException {

        String ipAddr = "172.25.20.133";
        String userName = "root";
        String password = "Suntek123";
        String cmd = "cd /opt/aos && ./startup.sh";

//        a) 连接：
        Connection conn = new Connection(ipAddr);
        conn.connect();

//        b)认证：
        boolean authenticateVal = conn.authenticateWithPassword(userName, password);

//        c) 打开一个Session:
        Session session = null;
        if (authenticateVal) {
            session = conn.openSession();
        }

        // 建立虚拟终端
        session.requestPTY("bash");

// 打开一个Shell
        session.startShell();

// 准备输入命令
        PrintWriter out = new PrintWriter(session.getStdin());

        // 输入待执行命令
        out.println(cmd);
        out.println("exit");

// 6. 关闭输入流
        out.close();

        // 7. 等待，除非1.连接关闭；2.输出数据传送完毕；3.进程状态为退出；4.超时
        session.waitForCondition(ChannelCondition.CLOSED | ChannelCondition.EOF | ChannelCondition.EXIT_STATUS, 30000);
        System.out.println(IOUtils.toString(session.getStdout(), "utf-8"));
    }
}
