package com.demo.springcloud.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "文件操作")
@RestController
@Slf4j
@RequestMapping("/file")
public class FileController {

}
