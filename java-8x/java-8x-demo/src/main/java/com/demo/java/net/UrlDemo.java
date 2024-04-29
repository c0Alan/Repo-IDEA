package com.demo.java.net;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL api 实例
 *
 * @author liuxilin
 * @date 2022年03月19日 22:26
 */
@Slf4j
public class UrlDemo {

    /**
     * 根据图片URL下载图片
     * 参考: https://www.cnblogs.com/cuijiade/p/9400953.html
     *
     * @param imgUrl 图片URL
     * @param dest   下载目标文件
     */
    public static void downloadImg(String imgUrl, String dest) {

        try {
            URL url = new URL(imgUrl);
            InputStream inputStream = URLUtil.getStream(url);
            FileUtil.writeFromStream(inputStream, dest);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 下载多张图片, 并最终合并到同一个目标文件
     */
    public static void downloadImg() {
        String imgUrlPrefix = "https://img.wendangwang.com/pic/82ca13a91fd8d307c0e9710a/";
        String imgUrlSurfix = "-1092-jpg_6_0_______-642-0-0-642.jpg";

        for (int i = 1; i <= 120; i++) {
            String imgUrl = imgUrlPrefix + i + imgUrlSurfix;
            String index = StrUtil.fillBefore(String.valueOf(i), '0', 3);
            String dest = "D:\\Download\\img" + index + ".jpg";
            downloadImg(imgUrl, dest);
            log.info("已下载: {}", dest);
        }
    }
}
