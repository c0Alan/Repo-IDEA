package com.demo.springcloud.hutool;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * FileUtil Demo
 * @author liuxilin
 * @date 2022年05月18日 23:01
 */
public class FileUtilDemo {
    public static void main(String[] args) {
        demo01();
    }

    /**
     * 将 listarray<String> 对象内容保存到TXT文件
     */
    public static void demo01(){
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");

        File dest = FileUtil.newFile("D:\\dest.txt");
        FileUtil.appendLines(list, dest, Charset.forName("UTF-8"));
    }
}
