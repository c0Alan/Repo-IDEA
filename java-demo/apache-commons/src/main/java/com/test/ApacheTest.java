package com.test;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;

/**
 * @author liuxilin
 * @version 2018/8/3
 * @Copyright (C)2017 , Suntektech
 * @since 6.0
 */
public class ApacheTest {

    @Test
    public void test() throws IOException {
        File f = new File("F:\\HikCStor=pic.jpg");
        test2(f);
        InputStream in = new FileInputStream(f);
        test2(in);
        byte[] bytes = "aaabbb".getBytes();
        test2(bytes);
    }

    public void test2(Object obj) throws IOException {
        System.out.println(obj instanceof File);
        if(obj instanceof File){
            System.out.println(((File)obj).getAbsolutePath());
        }
        System.out.println(obj instanceof InputStream);
        if(obj instanceof InputStream){
            System.out.println(((InputStream)obj).available());
        }
        System.out.println(obj instanceof byte[]);
        if(obj instanceof byte[]){
            System.out.println(((byte[])obj).length);
        }
    }

    @Test
    public void test3() throws Exception {
        File f = new File("F:\\HikCStor=pic.mp3");
        System.out.println(f.getAbsolutePath());
        System.out.println(URLConnection.guessContentTypeFromName(f.getAbsolutePath()));
//        System.out.println(URLConnection.guessContentTypeFromStream(new FileInputStream(f)));

    }
}
