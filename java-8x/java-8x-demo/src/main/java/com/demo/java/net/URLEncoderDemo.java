package com.demo.java.net;

import org.junit.Test;

import java.io.*;
import java.net.*;

public class URLEncoderDemo {


    /**
     * 使用URL编解码
     */
    @Test
    public void test01() {

        String encode = null;
        try {
            encode = URLEncoder.encode("GBK编码", "GBK");
            System.out.println("GBK编码后：" + encode);
            String decode = URLDecoder.decode(encode, "GBK");// GBK解码
            System.out.println("GBK解码后：" + decode);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}