package com.demo.springcloud.enums;

import com.demo.springcloud.exception.IBizExceptionEnum;
import lombok.Getter;

@Getter
public enum BizExceptionEnum implements IBizExceptionEnum {
    ENTITY_IS_NULL("Biz_Exception_0001", "实体为空"),
    ENTITY_ID_IS_NULL("Biz_Exception_0002", "实体id字段为空"),
    ENTITY_ID_IS_DUPLCATED("Biz_Exception_0003", "实体id字段%s重复");
 
    private final String code;
    private final String message;
 
    BizExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}