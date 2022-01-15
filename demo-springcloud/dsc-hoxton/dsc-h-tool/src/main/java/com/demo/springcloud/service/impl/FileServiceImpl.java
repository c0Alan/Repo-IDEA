package com.demo.springcloud.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.demo.springcloud.config.AppFileConfig;
import com.demo.springcloud.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

@Slf4j
@Service("fileService")
public class FileServiceImpl implements FileService {
    @Autowired
    AppFileConfig appFileConfig;

    @Autowired
    AbstractEnvironment environment;

    /**
     * 通过 java -D 在启动参数中设置环境参数，传入应用路径
     * @return
     */
    @Override
    public String readFileFromAppHome() {
        String result = "";
        String absolutePath = environment.getProperty("appHomeDir", "");
        String envtest = environment.getProperty("envtest", "");
        result += "envtest:" + envtest;
        if (StringUtils.isEmpty(absolutePath)) {
            absolutePath = "classpath:file/file1.json";
        } else {
            absolutePath = absolutePath + "/file/file1.json";
        }
        result += " absolutePath:" + absolutePath;
        result += " sysConfig.getAppHomeDir:" + appFileConfig.getAppHomeDir();
        File file = null;
        try {
            // 只能读取到jar包外部文件，不能读取jar包内部文件
            file = ResourceUtils.getFile(absolutePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        JSON json = JSONUtil.readJSON(file, Charset.defaultCharset());
        result += "file:" + json.toString();
        return result;
    }

    /**
     * 通过java程序获取应用路径
     * @return
     */
    @Override
    public String getApplicationHome() {
        ApplicationHome h = new ApplicationHome(getClass());
        String absolutePath = h.getSource().getParentFile().toString();
        absolutePath = StrUtil.subBefore(absolutePath, File.separator, true);
        return absolutePath;
    }

    @Override
    public String readFileApplicationHome(String filename) {
        String readPath = StrUtil.replace(appFileConfig.getReadPath(), "/", File.separator);
        String fullPath = getApplicationHome() + File.separator + readPath + File.separator + filename;
        return fullPath;
    }

    @Override
    public String getFilePath(String filename) {
        String readPath = StrUtil.replace(appFileConfig.getReadPath(), "/", File.separator);
        String fullPath = getApplicationHome() + File.separator + readPath + File.separator + filename;
        return fullPath;
    }

    @Override
    public String writeFileApplicationHome() {
        ApplicationHome h = new ApplicationHome(getClass());
        String absolutePath = h.getSource().getParentFile().toString();
        return absolutePath;
    }

    @Override
    public String readFileRelativePath() {
        return appFileConfig.getReadPath();
    }

    @Override
    public String readFileAbsolutePath() {
        return null;
    }

    @Override
    public String readFileResourcePath() {
        File file = null;
        try {
            // 这种方式本地开发环境可以获取到文件，但是打包成jar包部署是获取不到的
            file = ResourceUtils.getFile("classpath:file/file1.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        JSON json = JSONUtil.readJSON(file, Charset.defaultCharset());
        return json.toString();
    }

    @Override
    public String readFileResourcePathV2() {

        ResourceLoader resourceLoader = new DefaultResourceLoader();
        String result = null;
        try {
            // 这种方式本地开发环境可以获取到文件，打包成jar包部署也可以获取到文件
            InputStream inputStream = resourceLoader.getResource("classpath:file/file1.json").getInputStream();

            result = IOUtils.toString(inputStream, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String readFileResourcePathV3() {

        ClassPathResource resource = new ClassPathResource("file/file1.json");
        InputStream inputStream = null;
        String result = null;
        try {
            // 这种方式本地开发环境可以获取到文件，打包成jar包部署也可以获取到文件
            inputStream = resource.getInputStream();
            result = IOUtils.toString(inputStream, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
