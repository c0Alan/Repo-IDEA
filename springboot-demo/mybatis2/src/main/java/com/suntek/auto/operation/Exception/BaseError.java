package com.suntek.auto.operation.Exception;

/**
 * @author tantao
 * @version 2018/9/11
 * @Copyright (C)2018 , Suntektech
 * @since
 */
public class BaseError {

    private int code;
    private String message;

    public  BaseError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
