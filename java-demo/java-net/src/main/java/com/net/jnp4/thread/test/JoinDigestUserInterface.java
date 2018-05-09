package com.net.jnp4.thread.test;

import com.net.jnp4.thread.ReturnDigest;

import javax.xml.bind.DatatypeConverter;

/**
 * join 方法测试
 * 
 * @author liuxilin
 * @date 2018/5/8 23:00
 */
public class JoinDigestUserInterface {

    public static void main(String[] args) {

        ReturnDigest[] digestThreads = new ReturnDigest[args.length];

        for (int i = 0; i < args.length; i++) {
            // Calculate the digest
            digestThreads[i] = new ReturnDigest(args[i]);
            digestThreads[i].start();
        }

        for (int i = 0; i < args.length; i++) {
            try {
                digestThreads[i].join();
                // Now print the result
                StringBuffer result = new StringBuffer(args[i]);
                result.append(": ");
                byte[] digest = digestThreads[i].getDigest();
                result.append(DatatypeConverter.printHexBinary(digest));
                System.out.println(result);
            } catch (InterruptedException ex) {
                System.err.println("Thread Interrupted before completion");
            }
        }
    }
}