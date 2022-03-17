package com.demo.springcloud.controller;

import cn.hutool.json.JSONObject;
import com.demo.springcloud.config.AppFileConfig;
import com.demo.springcloud.service.FileService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "文件操作")
@RestController
@Slf4j
@RequestMapping("/file")
public class FileController {

    @Autowired
    FileService fileService;

    @Autowired
    AppFileConfig appFileConfig;

    @GetMapping("/readUserFile")
    public String readUserFile(){
        String result = fileService.readFileApplicationHome(appFileConfig.getUserJsonFilename());
        return result;
    }

    @GetMapping("/readFileFromAppHome")
    public String readFileFromAppHome(){
        String result = fileService.readFileFromAppHome();
        return result;
    }

    @GetMapping("/readFileRelativePath")
    public String readFileRelativePath(){
        String result = fileService.readFileRelativePath();
        return result;
    }

    @GetMapping("/readFileAbsolutePath")
    public String readFileAbsolutePath(){
        List list = appFileConfig.getDictExcelSheets();
        String result = "";
        return result;
    }

    @GetMapping("/getApplicationHome")
    public String getAbsolutePath(){
        String result = fileService.getApplicationHome();
        return result;
    }

    @GetMapping("/readFileResourcePath")
    public String readFileResourcePath(){
        String result = fileService.readFileResourcePath();
        return result;
    }

    @GetMapping("/readFileResourcePathV2")
    public String readFileResourcePathV2(){
        String result = fileService.readFileResourcePathV2();
        return result;
    }

    @GetMapping("/readFileResourcePathV3")
    public String readFileResourcePathV3(){
        String result = fileService.readFileResourcePathV3();
        return result;
    }

    @GetMapping("/writeFile")
    public String writeFile(@RequestParam String name){
        String result = "";
        return result;
    }

    @GetMapping("/getJsonFile")
    public JSONObject getJsonFile(@RequestParam String filename){
        JSONObject result = fileService.getJsonFile(filename);
        return result;
    }
}
