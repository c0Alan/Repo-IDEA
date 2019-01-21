package com.java.jar;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxilin
 * @version 2019-01-21
 * @since
 */
public class MainClass {
    public static void main(String[] args) {
        try {
            String dir = "testDir";
            String file = dir + File.separator + "testFile.log";
            File newDir = new File(dir);
            File newFile = new File(file);
            newDir.mkdirs();
            if (!newFile.exists()) {
                newFile.createNewFile();
            }
            List<String> lines = new ArrayList<>();
            lines.add("aaa");
            lines.add("bbb");
            OutputStreamWriter ow =  new OutputStreamWriter(new FileOutputStream(newFile, true));
;
            IOUtils.writeLines(lines, System.lineSeparator(), ow);
            IOUtils.writeLines(lines, System.lineSeparator(), ow);
            // 流关的时候才写
            IOUtils.closeQuietly(ow);

            OutputStreamWriter ow2 = new OutputStreamWriter(new FileOutputStream(newFile, true));
            ow2.write("testFlush");
            ow2.flush();
            ow2.close();

            FileInputStream fis = new FileInputStream(newFile);
            List<String> readLines = IOUtils.readLines(fis, "UTF-8");
            if (CollectionUtils.isNotEmpty(readLines)) {
                System.out.println(readLines.get(readLines.size() - 1));
            }
            fis.close();

        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }

    }
}
