package com.suntek.auto.operation.Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author tantao
 * @version 2018/9/11
 * @Copyright (C)2018 , Suntektech
 * @since
 */
@ControllerAdvice
public class OperationExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(OperationExceptionHandler.class);

    @ExceptionHandler(value = OperationException.class)
    public ResponseEntity<BaseError> handleOperationException(OperationException e) {
        ErrorCode errorCode = e.getErrorCode();

        LOG.error("业务处理失败 {}", e.getErrorCode().getMessage());

        return new ResponseEntity<>(new BaseError(errorCode.getCode(), errorCode.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
