package com.demo.springcloud.aspect;

import com.demo.springcloud.exception.BizException;
import com.demo.springcloud.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理切面
 * 参考：https://blog.csdn.net/2301_79644036/article/details/138108780
 *
 * @author liuxl
 * @date 2024/8/25
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandlerAdvice {

    @ExceptionHandler({BizException.class})
    public ResponseResult<Object> handleBizException(BizException e, HttpServletRequest request, HttpServletResponse response) {
        log.error(e.getCode() + ": " + e.getMessage(), e);
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return ResponseResult.fail(e.getCode(), e.getMessage());
    }

    @ExceptionHandler({RuntimeException.class, Exception.class})
    public ResponseResult<Object> handleRuntimeException(Exception e, HttpServletRequest request, HttpServletResponse response) {
        log.error(e.getMessage(), e);
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return ResponseResult.fail(e.getMessage());
    }
}
 