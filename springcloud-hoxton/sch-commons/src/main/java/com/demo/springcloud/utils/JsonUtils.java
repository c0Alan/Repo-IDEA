package com.demo.springcloud.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;

/**
 * 对Jackson中的方法进行了简单封装
 */
@Slf4j
public class JsonUtils {
    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * 将指定输入流解析为指定类型对象
     *
     * @param inputStream 输入流对象
     * @param tClass      指定类型
     * @return 返回一个指定类型对象
     */
    public static <T> T toBean(InputStream inputStream, Class<T> tClass) {
        try {
            return mapper.readValue(inputStream, tClass);
        } catch (IOException e) {
            log.error("json解析出错：" + inputStream, e);
            return null;
        }
    }

}