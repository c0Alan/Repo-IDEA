package com.demo.java.io;

import org.junit.Test;

import java.io.*;
import java.net.*;
import java.nio.charset.*;
import java.util.regex.*;

/**
 * 转换流，InputStreamReader 和 OutputStreamWriter
 * <p>
 * 转换流提供了在字节流和字符流之间的转换
 * Java API提供了两个转换流：
 * InputStreamReader：将InputStream转换为Reader（将一个字节的输入流转换为字符的输入流）
 * OutputStreamWriter：将Writer转换为OutputStream（将一个字符的输出流转换为字节的输出流 ）
 * 字节流中的数据都是字符时，转成字符流操作更高效。
 * 很多时候我们使用转换流来处理文件乱码问题。实现编码和解码的功能。
 * 解码：字节、字节数组 —>字符数组、字符串
 * 编码：字符数组、字符串 —> 字节、字节数组
 *
 * @author liuxilin
 * @date 2022/8/7 10:54
 */
public class InputStreamReaderDemo {


    /**
     * 综合使用InputStreamReader和OutputStreamWriter
     */
    @Test
    public void test03() throws Exception {
        //1.造文件、造流
        File file1 = new File("data.txt");
        File file2 = new File("data_gbk.txt");

        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);

        InputStreamReader isr = new InputStreamReader(fis, "utf-8");
        OutputStreamWriter osw = new OutputStreamWriter(fos, "gbk");
        //2.读写过程
        char[] cbuf = new char[20];
        int len;
        while ((len = isr.read(cbuf)) != -1) {
            osw.write(cbuf, 0, len);
        }
        //3.关闭资源
        isr.close();
        osw.close();
    }


    /**
     * 使用 InputStreamReader 读取文件data.txt，并打印到控制台
     */
    @Test
    public void test02() throws IOException {

        FileInputStream fis = new FileInputStream("data.txt");
//        InputStreamReader isr = new InputStreamReader(fis);//使用系统默认的字符集
        //参数2指明了字符集，具体使用哪个字符集，取决于文件dbcp.txt保存时使用的字符集
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");//使用系统默认的字符集

        char[] cbuf = new char[20];
        int len;
        while ((len = isr.read(cbuf)) != -1) {
            String str = new String(cbuf, 0, len);
            System.out.print(str);
        }

        isr.close();

    }


    /**
     * 匹配 <a href 开头内容，打印网页中匹配 <a href 开头内容
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
