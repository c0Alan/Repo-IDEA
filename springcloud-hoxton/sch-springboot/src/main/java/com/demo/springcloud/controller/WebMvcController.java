package com.demo.springcloud.controller;

import cn.hutool.core.bean.BeanUtil;
import com.demo.springcloud.entity.SysUser;
import com.demo.springcloud.entity.qo.SysUserQo;
import com.demo.springcloud.enums.BizExceptionEnum;
import com.demo.springcloud.event.UserUpdatePublisher;
import com.demo.springcloud.exception.BizException;
import com.demo.springcloud.response.ResponseResult;
import com.demo.springcloud.service.DemoService;
import com.demo.springcloud.validate.SysUserQoValidGroupA;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Base64Utils;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 接口示例
 *
 * @author liuxl
 * @date 2024/8/25
 */
@Api(tags = "webMvc接口示例")
@Slf4j
@RestController
@RequestMapping("/webMvc")
public class WebMvcController {

    @Autowired
    UserUpdatePublisher userUpdatePublisher;

    @Autowired
    DemoService demoService;


    @ApiOperation(value = "pathVariable")
    @GetMapping("/pathVariable/{id}")
    public SysUser pathVariable(@PathVariable Integer id) {
        SysUser user = new SysUser();
        user.setUsername("user" + id);
        user.setId(id);
        return user;
    }

    @ApiOperation(value = "requestParam")
    @GetMapping("/requestParam")
    public SysUser requestParam(@RequestParam Integer id) {
        SysUser user = new SysUser();
        user.setId(id);
        return user;
    }

    @ApiOperation(value = "requestBody")
    @PostMapping("/requestBody")
    public List<SysUser> requestBody(@RequestBody SysUser userQo) {
        List<SysUser> users = new ArrayList<>();
        users.add(new SysUser(1, "user1", "123456"));
        users.add(new SysUser(2, "user2", "123456"));
        return users;
    }


    @ApiOperation(value = "responseEntity", notes = "返回ResponseEntity<SysUser>")
    @PostMapping("/responseEntity")
    public ResponseEntity<SysUser> responseEntity(@RequestBody SysUser user) {
        return ResponseEntity.ok(user);
    }

    @ApiOperation(value = "getUser, PostMapping, RequestBody方式", notes = "返回SysUser")
    @PostMapping("/getUser")
    public SysUser getUser(@RequestBody SysUser user) {
        return user;
    }

    @ApiOperation(value = "PutMapping, PathVariable+RequestBody方式")
    @PutMapping("/users/{id}")
    public ResponseEntity<SysUser> updateUser(@PathVariable Integer id, @RequestBody SysUser updatedUser) {
        updatedUser.setId(id);
        return ResponseEntity.ok(updatedUser);
    }

    /**
     * 获取sessionId
     */
    @ApiOperation(value = "getSessionId")
    @GetMapping("/getSessionId")
    public String getSessionId(HttpSession session) {
        session.setAttribute("username", "张三");
        return session.getId();
    }

    /**
     * CORS跨域
     * 参考: https://blog.csdn.net/cowbin2012/article/details/85194353
     */
    @ApiOperation(value = "cors")
    @GetMapping("/cors")
    public SysUser cors() {
        SysUser sysUser = new SysUser();
        sysUser.setUsername("张三");
        sysUser.setId(1);
        return sysUser;
    }

    /**
     * 统一响应格式返回
     * 参考：https://blog.csdn.net/2301_79644036/article/details/138108780
     *
     * @return
     */
    @ApiOperation(value = "responseResult")
    @GetMapping("/responseResult")
    public ResponseResult<SysUser> responseResult() {
        return ResponseResult.success(new SysUser(1, "张三", "123456"));
    }

    @ApiOperation(value = "responseResultList")
    @GetMapping("/responseResultList")
    public ResponseResult<List<SysUser>> responseResultList() {
        List<SysUser> users = new ArrayList<>();
        users.add(new SysUser(1, "张三", "123456"));
        users.add(new SysUser(2, "李四", "123456"));
        return ResponseResult.success(users);
    }

    /**
     * 统一异常处理
     * 参考：https://blog.csdn.net/2301_79644036/article/details/138108780
     *
     * @return
     */
    @ApiOperation(value = "exception1")
    @GetMapping("/exception1")
    public ResponseResult<Integer> exception1() {
        throw new BizException(BizExceptionEnum.ENTITY_IS_NULL);
    }

    @ApiOperation(value = "exception2")
    @GetMapping("/exception2")
    public void exception2() {
        throw new BizException(BizExceptionEnum.ENTITY_ID_IS_NULL);
    }

    @ApiOperation(value = "exception3")
    @GetMapping(value = "/exception3")
    public String exception3() {
        throw new BizException(BizExceptionEnum.ENTITY_ID_IS_DUPLCATED, "1");
    }

    @ApiOperation(value = "exception4")
    @GetMapping(value = "/exception4")
    public String exception4() {
        // 抛出ArithmeticException异常
        return String.valueOf(1 / 0);
    }

    /***************************************** 文件上传 *****************************************/
    /**
     * 单文件上传
     * 参考：https://blog.csdn.net/cowbin2012/article/details/85247053
     */
    @PostMapping("/uploadFile")
    @ResponseBody
    public Map<String, String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        log.info("[文件类型] - [{}]", file.getContentType());
        log.info("[文件名称] - [{}]", file.getOriginalFilename());
        log.info("[文件大小] - [{}]", file.getSize());
        String destination = new File(System.getProperty("user.dir")).getParent() + File.separator + "tmp" + File.separator + file.getOriginalFilename();
        log.info("[文件上传路径] - [{}]", destination);
        file.transferTo(new File(destination));
        Map<String, String> result = new HashMap<>(16);
        result.put("contentType", file.getContentType());
        result.put("fileName", file.getOriginalFilename());
        result.put("fileSize", file.getSize() + "");
        return result;
    }

    /**
     * 多文件上传
     */
    @PostMapping("/uploadFiles")
    @ResponseBody
    public List<Map<String, String>> uploadFiles(@RequestParam("files") MultipartFile[] files) throws IOException {
        if (files == null || files.length == 0) {
            return null;
        }
        String destination = new File(System.getProperty("user.dir")).getParent() + File.separator + "tmp" + File.separator;
        List<Map<String, String>> results = new ArrayList<>();
        for (MultipartFile file : files) {
            // TODO Spring Mvc 提供的写入方式
            file.transferTo(new File(destination + file.getOriginalFilename()));
            Map<String, String> map = new HashMap<>(16);
            map.put("contentType", file.getContentType());
            map.put("fileName", file.getOriginalFilename());
            map.put("fileSize", file.getSize() + "");
            results.add(map);
        }
        return results;
    }

    /**
     * base64上传
     */
    @PostMapping("/uploadBase64")
    @ResponseBody
    public void uploadBase64(String base64) throws IOException {
        // TODO BASE64 方式的 格式和名字需要自己控制
        // （如 png 图片编码后前缀就会是 data:image/png;base64,）
        String destination = new File(System.getProperty("user.dir")).getParent() + File.separator + "tmp" + File.separator + "test.jpg";
        final File tempFile = new File(destination);
        // TODO 防止有的传了 data:image/png;base64, 有的没传的情况
        String[] d = base64.split("base64,");
        final byte[] bytes = Base64Utils.decodeFromString(d.length > 1 ? d[1] : d[0]);
        FileCopyUtils.copy(bytes, tempFile);
    }

    /***************************************** 数据校验 *****************************************/
    @ApiOperation(value = "validated")
    @PostMapping("/validated")
    public ResponseResult<SysUser> validated(@Validated @RequestBody SysUserQo userQo) {
        SysUser sysUser = BeanUtil.copyProperties(userQo, SysUser.class);
        sysUser.setId(1);
        return ResponseResult.success(sysUser);
    }

    @ApiOperation(value = "validated2")
    @PostMapping("/validated2")
    public ResponseResult<SysUser> validated2(@Validated({SysUserQoValidGroupA.class}) @RequestBody SysUserQo userQo) {
        SysUser sysUser = BeanUtil.copyProperties(userQo, SysUser.class);
        sysUser.setId(1);
        return ResponseResult.success(sysUser);
    }

    /***************************************** 事件监听 *****************************************/
    /**
     * 事件监听
     * 参考：https://blog.csdn.net/qq_41296669/article/details/135087823
     */
    @ApiOperation(value = "eventListener")
    @PostMapping("/eventListener")
    public ResponseResult<SysUser> eventListener() {
        SysUser sysUser = new SysUser(1, "张三", "123456");
        userUpdatePublisher.publishEvent(sysUser);
        return ResponseResult.success(sysUser);
    }

    /***************************************** @Async *****************************************/
    @ApiOperation(value = "asyncMethod")
    @GetMapping("/asyncMethod")
    public ResponseResult<String> asyncMethod() {
        demoService.asyncMethod();
        return ResponseResult.success("asyncMethod");
    }

    /***************************************** cache *****************************************/
    @ApiOperation(value = "getUserCache")
    @PostMapping("/getUserCache")
    public ResponseResult<SysUser> getUserCache(@RequestBody SysUserQo user) {
        return ResponseResult.success(demoService.getUserCache(user));
    }

    @ApiOperation(value = "saveUserCache")
    @PostMapping("/saveUserCache")
    public ResponseResult saveUserCache(@RequestBody SysUser user) {
        demoService.saveUserCache(user);
        return ResponseResult.success("OK");
    }

    @ApiOperation(value = "deleteUserCache")
    @GetMapping("/deleteUserCache")
    public ResponseResult deleteUserCache(@RequestParam String username) {
        demoService.deleteUserCache(username);
        return ResponseResult.success("OK");
    }

    @ApiOperation(value = "deleteAllUserCache")
    @GetMapping("/deleteAllUserCache")
    public ResponseResult deleteAllUserCache() {
        demoService.deleteAllUserCache();
        return ResponseResult.success("OK");
    }

}
