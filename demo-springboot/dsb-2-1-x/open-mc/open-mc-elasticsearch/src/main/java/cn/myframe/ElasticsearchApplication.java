package cn.myframe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * 启动方法 --ll
 * 
 * @author  ynz
 * @email   ynz@rojao.cn
 * @version 创建时间：2018年6月25日 下午5:32:00
 */
@SpringBootApplication
public class ElasticSearchApplication {
	
	public static void main(String[] args){
        SpringApplication app = new SpringApplication(ElasticSearchApplication.class);
       // app.setWebEnvironment(false);
        app.run(args);
 }

}
