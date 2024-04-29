package com.demo.java.net.basic.http.download;

import java.io.*;

/**
 * 通过http实现断点续传功能
 * 始终无法运行通过， 后面看看其博客的实现吧
 *
 * @author liuxilin
 * @date 2018/5/12 19:09
 */
public class Main {
    public static void main(String[] args) throws Exception {
        HttpDownload httpDownload = new HttpDownload();
        DownloadEvent progress = new NewProgress();
        FileInputStream fis = new FileInputStream("E:\\01_Repos\\Repo-IDEA\\java-demo\\java-net\\src\\main\\resources\\download.txt");
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(
                fis));
        String s = "";
        String[] ss;
        while ((s = fileReader.readLine()) != null) {
            ss = s.split("[ ]+");
            if (ss.length > 2) {
                System.out.println("\r\n---------------------------");
                System.out.println("正在下载:" + ss[0]);
                System.out.println("文件保存位置:" + ss[1]);
                System.out.println("下载缓冲区大小:" + ss[2]);
                System.out.println("---------------------------");
                httpDownload.download(new NewProgress(), ss[0], ss[1], Integer
                        .parseInt(ss[2]));
            }
        }
        fileReader.close();
    }
}
