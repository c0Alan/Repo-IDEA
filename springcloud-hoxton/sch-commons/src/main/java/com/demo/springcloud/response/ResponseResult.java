package com.demo.springcloud.response;

import lombok.Data;

import javax.servlet.http.HttpServletResponse;

/**
 * 响应结果类
 *
 * @param <T> 任意类型
 */
@Data
public class ResponseResult<T> {

    /**
     * 请求id
     */
    private String requestId;
    /**
     * 响应状态码，200是正常，非200表示异常
     */
    private int status;
    /**
     * 异常编号
     */
    private String errorCode;
    /**
     * 异常信息
     */
    private String message;
    /**
     * 响应数据
     */
    private T data;

    public static <T> ResponseResult<T> success() {
        return success(HttpServletResponse.SC_OK, null, null);
    }

    public static <T> ResponseResult<T> success(T data) {
        return success(HttpServletResponse.SC_OK, null, data);
    }

    public static <T> ResponseResult<T> fail(String message) {
        return fail(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, null, message, null);
    }

    public static <T> ResponseResult<T> fail(String errorCode, String message) {
        return fail(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, errorCode, message, null);
    }

    public static <T> ResponseResult<T> success(int status, String message, T data) {
        ResponseResult<T> r = new ResponseResult<>();
        r.setStatus(status);
        r.setMessage(message);
        r.setData(data);

        return r;
    }

    public static <T> ResponseResult<T> fail(int status, String errorCode, String message) {
        return fail(status, errorCode, message, null);
    }

    public static <T> ResponseResult<T> fail(int status, String errorCode, String message, T data) {
        ResponseResult<T> r = new ResponseResult<>();
        r.setStatus(status);
        r.setErrorCode(errorCode);
        r.setMessage(message);
        r.setData(data);
        return r;
    }

}
 