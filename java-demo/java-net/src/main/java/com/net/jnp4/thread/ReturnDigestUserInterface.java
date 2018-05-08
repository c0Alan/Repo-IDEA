package com.net.jnp4.thread;

import javax.xml.bind.*; // for DatatypeConverter

/**
 * 使用存取方法获得线程输出的主程序
 * 
 * @author liuxilin
 * @date 2018/5/8 8:03
 */
public class ReturnDigestUserInterface {

    public static void main(String[] args) {
        for (String filename : args) {
            // Calculate the digest
            ReturnDigest dr = new ReturnDigest(filename);
            dr.start();

            // Now print the result
            StringBuilder result = new StringBuilder(filename);
            result.append(": ");
            byte[] digest = dr.getDigest();
            result.append(DatatypeConverter.printHexBinary(digest));
            System.out.println(result);
        }
    }
}