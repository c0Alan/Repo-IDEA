package com.demo.springcloud.entity;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import lombok.Data;

import javax.servlet.http.HttpServletRequest;

/**
 * 请求日志类，已废弃
 * @author liuxilin
 * @since 2023-08-13
 */
@Deprecated
@Data
public class RequestLogDto {
    String requestId;
    String url;
    String remoteIp;
    long beginTime;
    String beginFormat = "收到请求: requestId=%s, url=%s ,ip=%s";
    String endFormat = "响应请求: 耗时=%s, requestId=%s, url=%s ,ip=%s";

    public static RequestLogDto of(HttpServletRequest request) {
        RequestLogDto requestLogDto = new RequestLogDto();
        String requestId = getRequestId(request);
        requestLogDto.setRequestId(requestId);
        requestLogDto.setUrl(String.valueOf(request.getRequestURL()));
        requestLogDto.setRemoteIp(request.getRemoteAddr());
        requestLogDto.setBeginTime(System.currentTimeMillis());
        return requestLogDto;
    }

    public static String getRequestId(HttpServletRequest request) {
        String requestId = request.getHeader("requestId");
        if (StrUtil.isBlank(requestId)) {
            requestId = (String) request.getAttribute("requestId");
            if (StrUtil.isBlank(requestId)) {
                requestId = UUID.fastUUID().toString(true);
            }
        }
        request.setAttribute("requestId", requestId);
        return requestId;
    }

    public String getRequestLogBegin() {
        String log = String.format(beginFormat, requestId, url, remoteIp);
        return log;
    }

    public String getRequestLogEnd() {
        String log = String.format(endFormat, System.currentTimeMillis() - beginTime, requestId, url, remoteIp);
        return log;
    }
}
