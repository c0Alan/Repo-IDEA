package com.demo.ch3.taskexecutor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AsyncApi {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        AsyncTaskService service = context.getBean(AsyncTaskService.class);
        for(int i=0; i<=10; i++){
            service.executeAsyncTask(i);
            service.executeAsyncTaskPlus(i);
        }
        context.close();
    }
}
