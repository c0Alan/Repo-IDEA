package com.java.tools.custom.xml2markdown;

import org.apache.commons.io.FileUtils;
import org.apache.commons.text.StringEscapeUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 博客转载内容转工具
 *
 * @author liuxilin
 * @date 2019/5/12 21:13
 */
public class Xml2MarkdownApp {

    /**
     * 参数1: 转换类型
     * 参数2: 转换文件路径
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        String type = "CSDN";
        String filePath = ".";
        String fileName = "content.xml";
        String newFileName = "content-transformed.xml";
        if (args.length >= 1) {
            type = args[0];
        }
        if (args.length >= 2) {
            if ("classpath".equals(args[1])) {
                filePath = Xml2MarkdownApp.class.getClassLoader().getResource("").getPath();
            } else {
                type = args[1];
            }
        }
        File f = new File(filePath + File.separator + fileName);
        List<String> lines = null;

        lines = FileUtils.readLines(f, StandardCharsets.UTF_8);
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            String newLine = line.replaceFirst("^\\s+", "");

            // 转换 link
            String reg = "<link(.*?[^/])>";
            Pattern pattern = Pattern.compile(reg);
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                newLine = "<link" + matcher.group(1) + " />";
            }

            // 转换 代码
            String reg2 = "<pre class=\"has\" name=\"code\"><code class=\"(.*?)\">";
            Pattern pattern2 = Pattern.compile(reg2);
            Matcher matcher2 = pattern2.matcher(line);
            if (matcher2.find()) {
                newLine = "\r\n```" + matcher2.group(1)
                        .replace(" ", "")
                        .replace("hljs", "")
                        .replace("language-", "")
                        .replace("vbscript", "java")
                        .replace("delphi", "yaml")+ "\r\n";

                line = line.replaceAll("</span>", "");
                line = line.replaceAll("<span.*?>", "");
                String reg3 = ">([^<]+?)<";
                Pattern pattern3 = Pattern.compile(reg3);
                Matcher matcher3 = pattern3.matcher(line);
                while (matcher3.find()) {
                    /*if (matcher3.group(1).contains("<")
                            && matcher3.group(1).contains(">")) {
                        continue;
                    }*/
                    newLine = newLine + StringEscapeUtils.unescapeHtml4(matcher3.group(1)) + "\r\n";
                }
                newLine = newLine + "```" + "\r\n";
            }
            newLine = newLine.replace("https://gitee.com/cowboy2016/springboot2-open",
                    "https://github.com/c0Alan/Repo-IDEA/tree/master/springboot-demo/springboot-2-1-x")
            .replace("转载请注明出处", "本文转载自");
            lines.set(i, newLine);
        }

        lines.add("\r\n<h3><a name=\"t8\"></a>项目说明</h3>");
        File newFile = new File(filePath + File.separator + newFileName);
        if (newFile.exists()) {
            newFile.delete();
        }
        newFile.createNewFile();
        FileUtils.writeLines(newFile, lines);
    }
}
