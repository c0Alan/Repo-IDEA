package com.demo.springcloud.controller;

import com.demo.springcloud.entity.User;
import com.demo.springcloud.service.BaseDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Api(tags = "基础数据获取")
@RestController
@Slf4j
@RequestMapping("/baseData")
public class BaseDataController {
    @Autowired
    BaseDataService baseDataService;

    /**
     * 从 基础数据.xlsx 缓存基础数据
     *
     * @return
     */
    @GetMapping("/baseDataCache")
    public String baseDataCache() {
        String result = baseDataService.baseDataCache();
        return result;
    }

    /**
     * 获取随机 User 对象
     * @return
     */
    @GetMapping("/getRandomUser")
    public User getRandomUser() {
        return baseDataService.buildUserData();
    }

    /**
     * 获取随机 User 列表对象
     * @param size
     * @return
     */
    @ApiOperation(value = "获取随机 User 列表对象", notes = "获取随机 User 列表对象")
    @GetMapping("/getRandomUserList")
    public List<User> getRandomUserList(@RequestParam @ApiParam(value="列表大小, 必须>=1",required=true) int size) {
        return baseDataService.buildUserList(size);
    }

    /**
     * 获取随机数据列表
     * @param size
     * @return
     */
    @ApiOperation(value = "获取随机数据列表", notes = "获取随机数据列表")
    @GetMapping("/getRandomDataList")
    public Map getRandomDataList(@RequestParam @ApiParam(value="配置文件名称",required=true) String configFile,
                                 @RequestParam @ApiParam(value="列表大小, 必须>=1",required=true) int size) {
        return baseDataService.buildData(configFile, size);
    }
}
