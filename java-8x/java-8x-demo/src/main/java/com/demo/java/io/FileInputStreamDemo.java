package com.demo.java.io;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 文件流，FileInputStream、FileOutputStream 示例
 *
 * @author liuxl
 * @date 2024/6/20
 */
public class FileInputStreamDemo {


    /**
     * Nio读写文件，方式2，效率最快
     */
    @Test
    public void test0302() {
        long start = System.currentTimeMillis();
        String srcPath = "D:\\tmp\\mysql.zip";
        String destPath = "D:\\tmp\\mysql_copy.zip";

        File sf = new File(srcPath);
        File tf = new File(destPath);
        FileInputStream fi = null;
        FileOutputStream fo = null;
        FileChannel in = null;
        FileChannel out = null;
        try {
            fi = new FileInputStream(sf);
            fo = new FileOutputStream(tf);
            in = fi.getChannel();//得到对应的文件通道
            out = fo.getChannel();//得到对应的文件通道
            in.transferTo(0, in.size(), out);//连接两个通道，并且从in通道读取，然后写入out通道
        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            try {

                fi.close();
                in.close();
                fo.close();
                out.close();
            } catch (Exception e) {

                e.printStackTrace();
            }
        }
        System.out.println("复制完成，耗时：" + (System.currentTimeMillis() - start) + "毫秒");
    }

    /**
     * Nio读写文件，方式1, 效率与传统io差不多
     */
    @Test
    public void test0301() throws IOException {
        long start = System.currentTimeMillis();
        String srcPath = "D:\\tmp\\mysql.zip";
        String destPath = "D:\\tmp\\mysql_copy.zip";
        int allocate = 1024;
        ByteBuffer byteBuffer = ByteBuffer.allocate(allocate);
        FileInputStream inputStream = new FileInputStream(srcPath);
        FileChannel inChannel = inputStream.getChannel();

        FileOutputStream outputStream = new FileOutputStream(destPath);
        FileChannel outChannel = outputStream.getChannel();

        int length = inChannel.read(byteBuffer);
        while (length != -1) {

            byteBuffer.flip();//读取模式转换写入模式
            outChannel.write(byteBuffer);
            byteBuffer.clear(); //清空缓存，等待下次写入
            // 再次读取文本内容
            length = inChannel.read(byteBuffer);
        }
        outputStream.close();
        outChannel.close();
        inputStream.close();
        inChannel.close();

        System.out.println("复制完成，耗时：" + (System.currentTimeMillis() - start) + "毫秒");
    }

    /**
     * 文件拷贝，FileInputStream 读， FileOutputStream 写
     * 传统io读写文件
     */
    @Test
    public void test02() {
        long start = System.currentTimeMillis();
        String srcPath = "D:\\tmp\\mysql.zip";
        String destPath = "D:\\tmp\\mysql_copy.zip";
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            //
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //复制的过程
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                //
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        System.out.println("复制完成，耗时：" + (System.currentTimeMillis() - start) + "毫秒");

    }


    /**
     * 使用字节流FileInputStream处理文本文件，可能出现乱码。使用 InputStreamReader 转 utf-8 编码解决中文乱码问题
     */
    @Test
    public void test01() {
        FileInputStream fis = null;
        try {
            //1. 造文件
            File file = new File("data.txt");

            //2.造流
            fis = new FileInputStream(file);

            //3.读数据
            byte[] buffer = new byte[5];
            int len;//记录每次读取的字节的个数
            while ((len = fis.read(buffer)) != -1) {

                String str = new String(buffer, 0, len);
                System.out.print(str);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                //4.关闭资源
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

}
