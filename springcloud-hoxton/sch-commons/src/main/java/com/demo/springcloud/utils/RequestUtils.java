package com.demo.springcloud.utils;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

/**
 * HttpServletRequest 工具类
 */
@Slf4j
public class RequestUtils {

    /**
     * 从请求对象的输入流中获取指定类型对象
     *
     * @param request 请求对象
     * @param clazz   指定类型
     * @return 指定类型对象
     */
    public static <T> T read(HttpServletRequest request, Class<T> clazz) {
        try {
            return JsonUtils.toBean(request.getInputStream(), clazz);
        } catch (Exception e) {
            log.error("读取出错：" + clazz, e);
            return null;
        }
    }
}