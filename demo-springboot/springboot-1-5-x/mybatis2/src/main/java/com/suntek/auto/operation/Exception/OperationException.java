package com.suntek.auto.operation.Exception;

/**
 * @author tantao
 * @version 2018/9/11
 * @Copyright (C)2018 , Suntektech
 * @since
 */
public class OperationException extends RuntimeException {

    private ErrorCode errorCode;

    public OperationException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

}
