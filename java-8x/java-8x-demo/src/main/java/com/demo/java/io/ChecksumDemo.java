package com.demo.java.io;

import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;
import java.util.zip.*;


/**
 * 计算文件CRC checksum的4种方式
 *
 * @author liuxl
 * @date 2024/5/3
 */
public class ChecksumDemo {
    public static int BLOCK_SIZE = 1024;

    public static void main(String[] args) throws IOException {
        Path filename = Paths.get(System.getProperty("user.dir") + File.separator + "index.html");

        System.out.println("InputStream:");
        long start = System.currentTimeMillis();
        long crcValue = checksumInputStream(filename);
        long end = System.currentTimeMillis();
        System.out.println(Long.toHexString(crcValue));
        System.out.println((end - start) + " milliseconds");

        System.out.println("BufferedInputStream:");
        start = System.currentTimeMillis();
        crcValue = checksumBufferedInputStream(filename);
        end = System.currentTimeMillis();
        System.out.println(Long.toHexString(crcValue));
        System.out.println((end - start) + " milliseconds");

        System.out.println("RandomAccessFile:");
        start = System.currentTimeMillis();
        crcValue = checksumRandomAccessFile(filename);
        end = System.currentTimeMillis();
        System.out.println(Long.toHexString(crcValue));
        System.out.println((end - start) + " milliseconds");

        System.out.println("MappedFile:");
        start = System.currentTimeMillis();
        crcValue = checksumMappedFile(filename);
        end = System.currentTimeMillis();
        System.out.println(Long.toHexString(crcValue));
        System.out.println((end - start) + " milliseconds");
    }

    public static long checksumInputStream(Path filename) throws IOException {
        try (InputStream in = Files.newInputStream(filename)) {
            CRC32 crc = new CRC32();

            byte[] bytes = new byte[BLOCK_SIZE];
            int n;
            while ((n = in.read(bytes)) != -1) {
                crc.update(bytes, 0, n);
            }
            return crc.getValue();
        }
    }

    public static long checksumBufferedInputStream(Path filename) throws IOException {
        try (InputStream in = new BufferedInputStream(Files.newInputStream(filename))) {
            CRC32 crc = new CRC32();

            byte[] bytes = new byte[BLOCK_SIZE];
            int n;
            while ((n = in.read(bytes)) != -1) {
                crc.update(bytes, 0, n);
            }
            return crc.getValue();
        }
    }

    public static long checksumRandomAccessFile(Path filename) throws IOException {
        try (RandomAccessFile file = new RandomAccessFile(filename.toFile(), "r")) {
            long length = file.length();
            CRC32 crc = new CRC32();

            byte[] bytes = new byte[BLOCK_SIZE];
            for (long p = 0; p < length; p += BLOCK_SIZE) {
                file.seek(p);
                int n = file.read(bytes);
                crc.update(bytes, 0, n);
            }
            return crc.getValue();
        }
    }

    public static long checksumMappedFile(Path filename) throws IOException {
        try (FileChannel channel = FileChannel.open(filename)) {
            CRC32 crc = new CRC32();
            int length = (int) channel.size();
            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, length);

            byte[] bytes = new byte[BLOCK_SIZE];
            for (int p = 0; p < length; p += BLOCK_SIZE) {
                int n = Math.min(BLOCK_SIZE, length - p);
                buffer.get(bytes, 0, n);
                crc.update(bytes, 0, n);
            }
            return crc.getValue();
        }
    }


}
