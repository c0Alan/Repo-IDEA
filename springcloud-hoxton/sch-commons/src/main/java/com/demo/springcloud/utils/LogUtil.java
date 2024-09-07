package com.demo.springcloud.utils;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;

/**
 * 日志工具类
 *
 * @author liuxl
 * @date 2024/8/31
 */
@Slf4j
public class LogUtil {

    private static final HashSet<String> EXCLUDE_URIS = new HashSet<>();

    static {
        EXCLUDE_URIS.add("/actuator/");
    }

    public static void printRequestLog() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String uri = String.valueOf(request.getRequestURI());
        if (EXCLUDE_URIS.stream().anyMatch(excludeUri -> uri.startsWith(excludeUri) || excludeUri.equals(uri + "/"))) {
            return;
        }
        String requestId = getRequestId(request);
        String remoteIp = request.getRemoteAddr();

        log.info("收到请求: requestId={}, url={} ,ip={}", requestId, uri, remoteIp);
    }

    public static void printResponseLog(long logBeginTime) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String uri = String.valueOf(request.getRequestURI());
        if (EXCLUDE_URIS.stream().anyMatch(excludeUri -> uri.startsWith(excludeUri) || excludeUri.equals(uri + "/"))) {
            return;
        }
        String requestId = getRequestId(request);
        String remoteIp = request.getRemoteAddr();

        log.info("响应请求: cost={}, requestId={}, url={} ,ip={}", System.currentTimeMillis() - logBeginTime, requestId, uri, remoteIp);
    }

    public static String getRequestId(HttpServletRequest request) {
        String requestId = (String) request.getAttribute("requestId");
        if (StrUtil.isBlank(requestId)) {
            requestId = request.getHeader("requestId");
            if (StrUtil.isBlank(requestId)) {
                requestId = UUID.fastUUID().toString(true);
            }
            request.setAttribute("requestId", requestId);
        }
        return requestId;
    }

    public static String getRequestId() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        return getRequestId(request);
    }

    private static long getLogBeginTime(HttpServletRequest request) {
        return (long) request.getAttribute("logBeginTime");
    }
}
