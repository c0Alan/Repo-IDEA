package com.demo.springboot.entity;

import lombok.Data;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liuxilin
 * @since 2023-08-13
 */
@Data
public class RequestLogDto {
    String url;
    String remoteIp;
    long beginTime;
    String beginFormat = "内部接口请求开始: url=%s ,ip=%s";
    String endFormat = "内部接口请求结束: 耗时=%s,url=%s ,ip=%s";

    public static RequestLogDto init(HttpServletRequest request) {
        RequestLogDto requestLogDto = new RequestLogDto();
        requestLogDto.setUrl(String.valueOf(request.getRequestURL()));
        requestLogDto.setRemoteIp(request.getRemoteAddr());
        requestLogDto.setBeginTime(System.currentTimeMillis());
        return requestLogDto;
    }

    public String getRequestLogBegin(){
        String log = String.format(beginFormat, url, remoteIp);
        return log;
    }

    public String getRequestLogEnd(){
        String log = String.format(endFormat, System.currentTimeMillis() -beginTime, url, remoteIp);
        return log;
    }
}
