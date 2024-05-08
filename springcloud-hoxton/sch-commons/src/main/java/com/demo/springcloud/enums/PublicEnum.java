package com.demo.springcloud.enums;

/**
 * 公共枚举
 *
 * @author lc
 */
public enum PublicEnum {

    YES("1", "是"),
    NO("0", "否"),

    UNIQUE("0", "唯一"),
    NOT_UNIQUE("1", "不唯一"),

    NORMAL("0", "正常"),
    DISABLE("1", "停用"),
    DELETE("2", "删除");

    PublicEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
