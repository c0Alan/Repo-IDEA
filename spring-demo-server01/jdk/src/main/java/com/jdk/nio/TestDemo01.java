package com.jdk.nio;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * nio 测试类
 */
public class TestDemo01 {
    /**
     * nio 测试字节处理 FileChannel ByteBuffer
     */
    public static void testByteBuffer() {
        RandomAccessFile aFile = null;
        try {
            String file = TestDemo01.class.getClassLoader().getResource("nio.txt").getFile();
            aFile = new RandomAccessFile(file, "rw");
            FileChannel fileChannel = aFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(1024);

            int bytesRead = fileChannel.read(buf);
            System.out.println(bytesRead);

            while (bytesRead != -1) {
                buf.flip();
                while (buf.hasRemaining()) {
                    System.out.print((char) buf.get());
                }

                buf.compact();
                bytesRead = fileChannel.read(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (aFile != null) {
                    aFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * io 测试字节处理
     */
    public static void testByte() {
        InputStream in = null;
        try {
            in = TestDemo01.class.getClassLoader().getResourceAsStream("nomal_io.txt");
//            in = new BufferedInputStream(new FileInputStream("src/nomal_io.txt"));

            byte[] buf = new byte[1024];
            int bytesRead = in.read(buf);
            while (bytesRead != -1) {
                for (int i = 0; i < bytesRead; i++)
                    System.out.print((char) buf[i]);
                bytesRead = in.read(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        testByteBuffer();
    }
}
