package com.demo.java.tools.easyexcel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Accessors(chain = true)
public class UserVO {

    /**
     * 用户id
     */
    @ExcelProperty(value = {"个人信息", "用户id"}, index = 0)
    private Integer id;

    /**
     * 用户名
     */
    @ExcelProperty(value = {"个人信息", "用户名"}, index = 1)
    private String name;

    /**
     * 年龄
     */
    @ExcelProperty(value = {"个人信息", "年龄"}, index = 2)
    private Integer age;

    /**
     * 性别
     */
    @ExcelProperty(value = {"个人信息", "性别"}, index = 3)
    private String gender;

    /**
     * 地址
     */
    @ExcelProperty(value = {"个人信息", "地址"}, index = 4)
    private String address;

    /**
     * 创建时间
     */
    @ExcelProperty(value = {"个人信息", "创建时间"}, index = 5)
//    @ExcelIgnore
    private LocalDateTime createTime;

    /**
     * 工资
     */
    @ExcelProperty(value = {"个人信息", "工资"}, index = 6)
//    @ExcelProperty(value = "工资", order = 6)
    private Double salary;

}
