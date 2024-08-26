package com.demo.springcloud.exception;

import lombok.Data;

/**
 * 业务异常基类，支持参数化的异常信息
 */
@Data
public class BizException extends RuntimeException {
    private String code;
    private Object[] args;

    public BizException() {
        super();
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(Throwable cause, String code, String message, Object... args) {
        super(message, cause);
        this.code = code;
        this.args = args;
    }

    public BizException(String code, String message, Object... args) {
        super(message);
        this.code = code;
        this.args = args;
    }

    public BizException(IBizExceptionEnum exceptionEnum, Object... args) {
        this(exceptionEnum.getCode(), exceptionEnum.getMessage(), args);
    }

    public BizException(Throwable cause, IBizExceptionEnum exceptionEnum, Object... args) {
        this(cause, exceptionEnum.getCode(), exceptionEnum.getMessage(), args);
    }

    @Override
    public String getMessage() {
        if (code != null) {
            if (args != null && args.length > 0) {
                return String.format(super.getMessage(), args);
            }
        }
        return super.getMessage();
    }
}