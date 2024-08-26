package com.demo.springcloud.entity.qo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 * SysUser 查询对象
 *
 * @author liuxl
 * @date 2024/8/26
 */
@ApiModel("SysUser 查询对象")
@Data
public class SysUserQo {
    private Integer id;

    @NotBlank(message = "姓名不能为空")
    private String username;
    private String password;
    private Integer enabled;

    @NotNull(message = "年龄不能为空")
    @Min(value = 0, message = "年龄不能小于0")
    @Max(value = 200, message = "年龄不能大于200")
    private Integer age;

    private String telephone;
}
