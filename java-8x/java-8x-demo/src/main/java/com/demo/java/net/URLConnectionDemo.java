package com.demo.java.net;

import org.junit.Test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

/**
 * URLConnection 示例
 *
 * @author liuxilin
 * @date 2022/8/12 20:54
 */
public class URLConnectionDemo {
    public static void main(String[] args) {

    }

    /**
     * 提交一个表单
     */
    @Test
    public void test05() {
        URL url;
        try {
            url = new URL(
                    "http://www.cafeaulait.org/books/jnp4/postquery.phtml");
        } catch (MalformedURLException ex) { // shouldn't happen
            System.err.println(ex);
            return;
        }

        URLConnectionFormPoster poster = new URLConnectionFormPoster(url);
        poster.add("name", "Elliotte Rusty Harold");
        poster.add("email", "elharo@ibiblio.org");
        poster.add("test", "sss");

        try (InputStream in = poster.post()) {
            // Read the response
            Reader r = new InputStreamReader(in);
            int c;
            while ((c = r.read()) != -1) {
                System.out.print((char) c);
            }
            System.out.println();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    /**
     * getHeaderField 返回所有 Header
     */
    @Test
    public void test04() {
        String url = "https://repo1.maven.org/maven2/";
        try {
            URL u = new URL(url);
            URLConnection uc = u.openConnection();
            for (int j = 1; ; j++) {
                String header = uc.getHeaderField(j);
                if (header == null) {
                    break;
                }
                System.out.println(uc.getHeaderFieldKey(j) + ": " + header);
            }
        } catch (MalformedURLException ex) {
            System.err.println(url + " is not a URL I understand.");
        } catch (IOException ex) {
            System.err.println(ex);
        }
        System.out.println();

    }

    /**
     * 返回Header
     */
    @Test
    public void test03() {
        String url = "https://repo1.maven.org/maven2/";
        try {
            URL u = new URL(url);
            URLConnection uc = u.openConnection();
            System.out.println("Content-type: " + uc.getContentType());
            if (uc.getContentEncoding() != null) {
                System.out.println("Content-encoding: " + uc.getContentEncoding());
            }
            if (uc.getDate() != 0) {
                System.out.println("Date: " + new Date(uc.getDate()));
            }
            if (uc.getLastModified() != 0) {
                System.out.println("Last modified: " + new Date(uc.getLastModified()));
            }
            if (uc.getExpiration() != 0) {
                System.out.println("Expiration date: " + new Date(uc.getExpiration()));
            }
            if (uc.getContentLength() != -1) {
                System.out.println("Content-length: " + uc.getContentLength());
            }
        } catch (MalformedURLException ex) {
            System.err.println(url + " is not a URL I understand");
        } catch (IOException ex) {
            System.err.println(ex);
        }
        System.out.println();

    }

    /**
     * 从Web 网站下载二进制文件并保存到磁盘
     */
    @Test
    public void test02() {
        String url = "https://repo1.maven.org/maven2/commons-io/commons-io/2.16.1/commons-io-2.16.1.jar";
        try {
            URL root = new URL(url);
            saveBinaryFile(root);
        } catch (MalformedURLException ex) {
            System.err.println(url + " is not URL I understand.");
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    public static void saveBinaryFile(URL u) throws IOException {
        URLConnection uc = u.openConnection();
        String contentType = uc.getContentType();
        int contentLength = uc.getContentLength();
        if (contentType.startsWith("text/") || contentLength == -1) {
            throw new IOException("This is not a binary file.");
        }

        try (InputStream raw = uc.getInputStream()) {
            InputStream in = new BufferedInputStream(raw);
            byte[] data = new byte[contentLength];
            int offset = 0;
            while (offset < contentLength) {
                int bytesRead = in.read(data, offset, data.length - offset);
                if (bytesRead == -1) break;
                offset += bytesRead;
            }

            if (offset != contentLength) {
                throw new IOException("Only read " + offset
                        + " bytes; Expected " + contentLength + " bytes");
            }
            String filename = u.getFile();
            filename = filename.substring(filename.lastIndexOf('/') + 1);
            try (FileOutputStream fout = new FileOutputStream(filename)) {
                fout.write(data);
                fout.flush();
            }
        }
    }


    /**
     * 用 URLConnection丁载一个Web 页面
     */
    @Test
    public void test01() {
        String url = "https://repo1.maven.org/maven2/";
//        String url = "http://www.baidu.com";
        try {
            // Open the URLConnection for reading
            URL u = new URL(url);
            URLConnection uc = u.openConnection();
            try (InputStream raw = uc.getInputStream()) { // autoclose
                InputStream buffer = new BufferedInputStream(raw);
                // chain the InputStream to a Reader
                Reader reader = new InputStreamReader(buffer);
                int c;
                while ((c = reader.read()) != -1) {
                    System.out.print((char) c);
                }
            }
        } catch (MalformedURLException ex) {
            System.err.println(url + " is not a parseable URL");
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
