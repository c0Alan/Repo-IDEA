package com.demo.java.io;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * ZipInputStream、ZipOutputStream 示例
 *
 * @author liuxl
 * @date 2024/5/3
 */
public class ZipStreamDemo {
    public static void main(String[] args) throws IOException {

    }

    /**
     * 读取zip文件内容
     */
    @Test
    public void test01() throws IOException {
        String zipname = System.getProperty("user.dir") + File.separator + "index.zip";
        // Here, we use the classic zip API
        try (ZipInputStream zin = new ZipInputStream(new FileInputStream(zipname))) {
            ZipEntry entry;
            while ((entry = zin.getNextEntry()) != null) {
                System.out.println(entry.getName());

                Scanner in = new Scanner(zin, "UTF-8");
                while (in.hasNextLine()) {
                    System.out.println("   " + in.nextLine());
                }
                // DO NOT CLOSE in
                zin.closeEntry();
            }
        }
    }


}