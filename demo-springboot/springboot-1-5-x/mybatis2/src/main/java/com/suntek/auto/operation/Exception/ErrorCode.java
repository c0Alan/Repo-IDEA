package com.suntek.auto.operation.Exception;

/**
 * @author tantao
 * @version 2018/9/11
 * @Copyright (C)2018 , Suntektech
 * @since
 */
public enum ErrorCode {

    INCORRECT_PASSWORD(10001, "密码错误!"),
    INUSED_USER(10002, "账号错误!"),
    INCORRECT_MSG(10003, "验证码错误!");

    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
