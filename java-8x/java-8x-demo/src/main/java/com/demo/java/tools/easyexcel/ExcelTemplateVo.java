package com.demo.java.tools.easyexcel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author liuxl
 * @date 2024/11/10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ExcelTemplateVo {
    private String name;
    private Integer age;
}
