package com.demo.springcloud.controller;

import cn.hutool.core.util.StrUtil;
import com.demo.springcloud.config.MinioConfig;
import com.demo.springcloud.utils.MinioUtils;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

/**
 * Minio 接口示例
 * 参考：https://blog.csdn.net/cmh1008611/article/details/142777493
 *
 * @author liuxl
 * @date 2024/11/17
 */
@Log4j2
@Api(tags = "Minio 接口示例")
@RestController
@RequestMapping("/minio")
public class MinioController {

    @Autowired
    private MinioUtils minioUtils;

    @Autowired
    private MinioConfig minioConfig;

    /**
     * 文件上传
     *
     * @param file
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        try {
            //文件名
            String fileName = file.getOriginalFilename();
            String newFileName = System.currentTimeMillis() + "." + StrUtil.subAfter(fileName, ".", true);
            //类型
            String contentType = file.getContentType();
            minioUtils.uploadFile(minioConfig.getBucketName(), file, newFileName, contentType);
            return "上传成功";
        } catch (Exception e) {
            log.error("上传失败", e);
            return "上传失败";
        }
    }

    /**
     * 删除
     *
     * @param fileName
     */
    @DeleteMapping("/")
    public void delete(@RequestParam("fileName") String fileName) {
        minioUtils.removeFile(minioConfig.getBucketName(), fileName);
    }

    /**
     * 获取文件信息
     *
     * @param fileName
     * @return
     */
    @GetMapping("/info")
    public String getFileStatusInfo(@RequestParam("fileName") String fileName) {
        return minioUtils.getFileStatusInfo(minioConfig.getBucketName(), fileName);
    }

    /**
     * 获取文件外链
     *
     * @param fileName
     * @return
     */
    @GetMapping("/url")
    public String getPresignedObjectUrl(@RequestParam("fileName") String fileName) {
        return minioUtils.getPresignedObjectUrl(minioConfig.getBucketName(), fileName);
    }

    /**
     * 文件下载
     *
     * @param fileName
     * @param response
     */
    @GetMapping("/download")
    public void download(@RequestParam("fileName") String fileName, HttpServletResponse response) {
        try {
            // 从 MinIO 获取指定的对象（文件）的输入流
            InputStream fileInputStream = minioUtils.getObject(minioConfig.getBucketName(), fileName);
            // 设置响应头，指明这是一个附件下载，并指定下载文件的名称
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            // 设置响应的内容类型为强制下载
            response.setContentType("application/force-download");
            // 设置响应的字符编码为 UTF-8
            response.setCharacterEncoding("UTF-8");
            // 将输入流中的文件内容复制到响应输出流中
            IOUtils.copy(fileInputStream, response.getOutputStream());
            response.flushBuffer(); // 刷新响应输出流
        } catch (Exception e) {
            log.error("下载失败, {}", e.getMessage());
        }
    }
}