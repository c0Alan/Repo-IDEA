package com.demo.java.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * BufferedReader 示例
 *
 * @author liuxl
 * @date 2024/5/3
 */
public class BufferedReaderDemo {

    public static void main(String[] args) throws IOException {
        BufferedReaderDemo demo = new BufferedReaderDemo();
        demo.test01();
    }

    /**
     * 文件读取
     */
    @Test
    public void test01() throws IOException {
        String fileName = System.getProperty("user.dir") + File.separator + "data.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String result = br.readLine();
            System.out.println(result);
        }

    }
}
