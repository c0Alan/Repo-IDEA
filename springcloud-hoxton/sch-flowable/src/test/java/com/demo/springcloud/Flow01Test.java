package com.demo.springcloud;


import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Flow01Test {

    @Resource
    private RepositoryService repositoryService;

    @Resource
    private RuntimeService runtimeService;

    @Resource
    private TaskService taskService;


    /**
     * ① 部署流程
     */
    @Test
    public void deploy() {
        Deployment deploy = repositoryService.createDeployment()
                .addClasspathResource("flowable/flow01.bpmn20.xml")
                .name("请假-01")
                .deploy();
        System.out.println("deploy.getId() = " + deploy.getId());
    }

    /**
     * ② 启动流程
     */
    @Test
    public void startProcess() {
        // 根据流程id启动流程===》注意使用自己的流程id
        ProcessInstance instance = runtimeService.startProcessInstanceById("flow01:1:409d3a72-aa56-11ef-9f8c-005056c00001");
        System.out.println(instance.getId());
    }

    /**
     * ③ 审批流程任务
     */
    @Test
    public void assigneeTask() {
        // 根据审批人查找要审批的任务
        List<Task> list = taskService.createTaskQuery().taskAssignee("admin").list();
        list.forEach(task -> {
            System.out.println(task.getId());
            // 审批任务
            taskService.complete(task.getId());
        });
    }


}
