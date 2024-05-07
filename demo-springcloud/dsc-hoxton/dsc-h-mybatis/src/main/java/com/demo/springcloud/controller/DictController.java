package com.demo.springcloud.controller;

import com.demo.springcloud.entity.Dict;
import com.demo.springcloud.entity.User;
import com.demo.springcloud.remote.DictService;
import com.demo.springcloud.remote.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dict")
public class DictController {

    @Autowired
    private DictService dictService;

    /**
     * 获取当前系统字典id值
     * @return
     */
    @ApiOperation("获取当前系统字典id值")
    @GetMapping("/getCurrentSysDictId")
    public int getCurrentSysDictId() {
        return dictService.getCurrentSysDictId();
    }

    /**
     * 批量新增字典
     *
     * @param dictList
     * @return
     */
    @ApiOperation("批量新增字典")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dictList",value = "json对象", required = true, paramType = "body")
    })
    @PostMapping("/saveDictList")
    public int saveDictList(@RequestBody List<Dict> dictList){
        return dictService.saveDictList(dictList);
    }


}
