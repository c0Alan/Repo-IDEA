package cn.myframe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动方法
 *
 * @author ynz
 * @version 创建时间：2018年6月25日 下午5:32:00
 * @email ynz@rojao.cn
 */
@SpringBootApplication
public class BaseConfigApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(BaseConfigApplication.class);
        // app.setWebEnvironment(false);
        app.run(args);
    }

}
