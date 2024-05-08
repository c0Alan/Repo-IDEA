package com.demo.springcloud.entity;


/**
 * web层通用数据处理
 *
 * @author lc
 */
public class BaseController {
    /**
     * 返回成功
     */
    public Result success() {
        return Result.success();
    }

    /**
     * 返回成功消息
     */
    public Result success(Object data) {
        return Result.success(data);
    }

    /**
     * 返回成功消息和数据
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public Result success(String msg, Object data) {
        return Result.success(msg, data);
    }

    /**
     * 返回失败消息
     */
    public Result error() {
        return Result.error();
    }

    /**
     * 返回失败消息
     */
    public Result error(Object message) {
        return Result.error(message);
    }


    /**
     * 返回错误消息和数据
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public Result error(String msg, Object data) {
        return Result.error(msg, data);
    }

    /**
     * 返回错误码消息
     */
    public Result error(Result.Type type, String message) {
        return new Result(type, message);
    }


    /**
     * 返回无权限
     */
    public Result unauth() {
        return Result.unauth();
    }

    /**
     * 返回无权限消息
     */
    public Result unauth(String message) {
        return Result.unauth(message);
    }

}
