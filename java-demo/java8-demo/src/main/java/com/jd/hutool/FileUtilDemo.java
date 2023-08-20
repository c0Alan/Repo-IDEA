package com.jd.hutool;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ObjectUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.nio.charset.Charset;
import java.util.*;

/**
 * FileUtil Demo
 *
 * @author liuxilin
 * @date 2022年05月18日 23:01
 */
@Slf4j
public class FileUtilDemo {
    public static void main(String[] args) {
        tool();
    }

    /**
     * 将 listarray<String> 对象内容保存到TXT文件
     */
    public static void demo01() {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");

        File dest = FileUtil.newFile("D:\\dest.txt");
        FileUtil.appendLines(list, dest, Charset.forName("UTF-8"));
    }

    public static void tool() {
        List<String> lines = FileUtil.readUtf8Lines("D:\\wmz.txt");
        Map result = new TreeMap();
        Map userResult = new TreeMap();
        for (String line : lines) {
            if (line.startsWith("INFO")) {
                continue;
            }
            if (line.contains("重新创建对象成功")) {
                continue;
            }
            String key = line.substring(0, 13);
            String user = line.substring(line.indexOf("[") + 1, line.indexOf("]"));
            user = user.substring(0, user.indexOf("-"));

            int num = 0;
            if (ObjectUtil.isNull(result.get(key))) {
                num = 0;
            } else {
                num = (int) result.get(key);
            }
            num++;
            result.put(key, num);

            Set userSet = (Set) userResult.get(key);
            if (ObjectUtil.isNull(userSet)) {
                userSet = new TreeSet();
            }
            userSet.add(user);
            userResult.put(key, userSet);
        }


        for (Object key : result.keySet()) {
            log.info("{}:{}", key, result.get(key));
        }
        log.info("---------------------------------------------------------------");

        for (Object key : userResult.keySet()) {
            log.info("{}:{}:{}", key, ((Set) userResult.get(key)).size(), userResult.get(key));
        }
    }
}
