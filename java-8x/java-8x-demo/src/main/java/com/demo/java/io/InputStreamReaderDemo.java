package com.demo.java.io;

import org.junit.Test;

import java.io.*;
import java.net.*;
import java.nio.charset.*;
import java.util.regex.*;

/**
 * 匹配 <a href 开头内容
 *
 * @author liuxilin
 * @date 2022/8/7 10:54
 */
public class InputStreamReaderDemo {


    /**
     * 打印网页中匹配 <a href 开头内容
     */
    @Test
    public void test01() {
        try {
            // get URL string from command line or use default
            String urlString = "https://www.cnblogs.com";

            // open reader for URL
            InputStreamReader in = new InputStreamReader(new URL(urlString).openStream(), StandardCharsets.UTF_8);

            // read contents into string builder
            StringBuilder input = new StringBuilder();
            int ch;
            while ((ch = in.read()) != -1) {
               input.append((char) ch);
            }

            // search for all occurrences of pattern
            String patternString = "<a\\s+href\\s*=\\s*(\"[^\"]*\"|[^\\s>]*)\\s*>";
            Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                String match = matcher.group();
                System.out.println(match);
            }
        } catch (IOException | PatternSyntaxException e) {
            e.printStackTrace();
        }
    }
}
