package com.springboot.ch9_2.web;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    /** 启动job的接口 */
    @Autowired
    JobLauncher jobLauncher;

    /** 实际执行的jog, 包含一个或多个Step, Step-步骤包含ItemReader 、ItemProcessor 和ItemWrter */
    @Autowired
    Job importJob;

    /**
     * 参数后置绑定
     * 我们在ltemReader 和ItemWriter 的Bean 定义的时候，参数已经硬编码在Bean 的初始化中
     * 要实现参数的后置绑定，我们可以在JobParameters 中绑定参数.
     * 在bean定义的时候, 用一个特殊的bean生命周期注解@StepScope:
     * 然后通过@Value 注入此参数。
     */
    public JobParameters jobParameters;

    @RequestMapping("/read")
    public String imp(String fileName) throws Exception {

        String path = fileName + ".csv";
        jobParameters = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .addString("input.file.name", path)
                .toJobParameters();
        jobLauncher.run(importJob, jobParameters);
        return "ok";
    }

}
