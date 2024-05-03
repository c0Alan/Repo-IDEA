package com.demo.java.io;


import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Files 示例
 *
 * @author liuxl
 * @date 2024/5/3
 */
public class FilesDemo {


    /**
     * 读取zip文件内容
     */
    @Test
    public void test02() throws IOException {
        String zipname = System.getProperty("user.dir") + File.separator + "index.zip";
        // Here, we make a Java SE 7 file system
        FileSystem fs = FileSystems.newFileSystem(Paths.get(zipname), null);
        Files.walkFileTree(fs.getPath("/"), new SimpleFileVisitor<Path>() {
            public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
                System.out.println(path);
                for (String line : Files.readAllLines(path, Charset.forName("UTF-8"))) {
                    System.out.println("   " + line);
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }

    /**
     * 遍历目录及子目录下的所有文件（非目录）
     */
    @Test
    public void test01() throws IOException {
        String path = System.getProperty("user.dir");
        Path dir = Paths.get(path);
        Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (attrs.isDirectory()) {
                    System.out.println("dir: " + file.toAbsolutePath());
                } else {
                    System.out.println("file: " + file.toAbsolutePath());
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
