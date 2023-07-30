package com.sch.entity;

import cn.hutool.core.bean.BeanUtil;
import lombok.Data;

/**
 * @author liuxilin
 * @date 2022年02月12日 22:40
 */
@Data
public class Foo {
    private Integer size = 10;
    private Boolean sample = true;
    private String name = "Tom";

    public Object get(String attr) {
        return BeanUtil.getFieldValue(this, attr);
    }

}
