package com.demo.java.net.old.download;

import java.net.*;
import java.io.*;
import java.util.*;

public class HttpDownload {
    private HashMap httpHeaders = new HashMap();
    private String responseCode;

    private void generateHttpRequest(OutputStream out, String host,
                                     String path, long startPos) throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(out);
        writer.write("GET " + path + " HTTP/1.1\r\n");
        writer.write("Host: " + host + "\r\n");
        writer.write("Accept: */*\r\n");
        writer.write("User-Agent: My First Http Download\r\n");
        if (startPos > 0)
            writer.write("Range: bytes=" + String.valueOf(startPos) + "-\r\n");
        writer.write("Connection: close\r\n\r\n");
        writer.flush();
    }

    private void analyzeHttpHeader(InputStream inputStream, DownloadEvent de)
            throws Exception {
        String s = "";
        byte b = -1;
        while (true) {
            b = (byte) inputStream.read();
            if (b == '\r') {
                b = (byte) inputStream.read();
                if (b == '\n') {
                    if (s.equals("")) {
                        break;
                    }
                    de.viewHttpHeaders(s);
                    addHeaderToMap(s);
                    s = "";
                }
            } else {
                s += (char) b;
            }
        }
    }

    private void analyzeFirstLine(String s) {
        String[] ss = s.split("[ ]+");
        if (ss.length > 1) {
            responseCode = ss[1];
        }
    }

    private void addHeaderToMap(String s) {
        int index = s.indexOf(":");
        if (index > 0) {
            httpHeaders.put(s.substring(0, index), s.substring(index + 1)
                    .trim());
        } else {
            analyzeFirstLine(s);
        }
    }

    private String getHeader(String header) {
        return (String) httpHeaders.get(header);
    }

    private int getIntHeader(String header) {
        return Integer.parseInt(getHeader(header));
    }

    public long getFileLength() {
        long length = -1;
        try {
            length = getIntHeader("Content-Length");
            String[] ss = getHeader("Content-Range").split("[/]");
            if (ss.length > 1) {
                length = Integer.parseInt(ss[1]);
            } else {
                length = -1;
            }
        } catch (Exception e) {
        }
        return length;
    }

    public void download(DownloadEvent de, String url, String localFN,
                         int cacheSize) throws Exception {
        File file = new File(localFN);
        long finishedSize = 0;
        long contentLength = 0;
        FileOutputStream fileOut = new FileOutputStream(localFN, true);
        URL myUrl = new URL(url);
        Socket socket = new Socket();
        byte[] buffer = new byte[cacheSize]; // 下载数据的缓冲

        if (file.exists()) {
            finishedSize = file.length();
        }

        // 得到要下载的Web资源的端口号，未提供，默认是80
        int port = (myUrl.getPort() == -1) ? 80 : myUrl.getPort();
        de.state("正在连接" + myUrl.getHost() + ":" + String.valueOf(port));
        socket.connect(new InetSocketAddress(myUrl.getHost(), port), 20000);
        de.state("连接成功!");

        // 产生HTTP请求消息
        generateHttpRequest(socket.getOutputStream(), myUrl.getHost(), myUrl
                .getPath(), finishedSize);

        InputStream inputStream = socket.getInputStream();
        // 分析HTTP响应消息头
        analyzeHttpHeader(inputStream, de);
        contentLength = getFileLength();
        if (finishedSize >= contentLength) {
            return;
        } else {
            if (finishedSize > 0 && responseCode.equals("200")) {
                return;
            }
        }
        if (responseCode.charAt(0) != '2' && !"301".equals(responseCode)) {
            throw new Exception("不支持的响应码");
        }
        int n = 0;
        long m = finishedSize;
        while ((n = inputStream.read(buffer)) != -1) {
            fileOut.write(buffer, 0, n);
            m += n;
            if (contentLength != -1) {
                de.percent(m * 100 / contentLength);
            }
        }
        fileOut.close();
        socket.close();
    }
}
