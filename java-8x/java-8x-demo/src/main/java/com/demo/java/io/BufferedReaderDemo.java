package com.demo.java.io;

import org.junit.Test;

import java.io.*;

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
        String copyName = System.getProperty("user.dir") + File.separator + "data2.txt";
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        BufferedWriter bw = new BufferedWriter(new FileWriter(copyName));
        try {
            String result = br.readLine();
            while (result != null){
                bw.write(result);
                bw.newLine();
                result = br.readLine();
            }
            bw.flush();
            System.out.println(result);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
