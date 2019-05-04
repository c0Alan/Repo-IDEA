package cn.myframe;

import com.alibaba.csp.sentinel.init.InitExecutor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * 启动方法
 * 
 * @author  ynz
 * @email   ynz@myframe.cn
 * @version 创建时间：2018年6月25日 下午5:32:00
 */
@SpringBootApplication
public class NettyApplication {
	
	public static void main(String[] args){
        System.setProperty("project.name","xxx");
        System.setProperty("csp.sentinel.dashboard.server","127.0.0.1:8080");
        InitExecutor.doInit();
        SpringApplication app = new SpringApplication(NettyApplication.class);
       // app.setWebEnvironment(false);
        app.run(args);
	}

}
