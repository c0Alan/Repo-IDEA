package com.demo.springcloud.controller;

import com.demo.springcloud.response.ResponseResult;
import com.demo.springcloud.service.SchSpringbootService;
import com.demo.springcloud.utils.LogUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Api(tags = "接口示例")
@RestController
@Slf4j
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private SchSpringbootService schSpringbootService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RestTemplate loadBalancedRestTemplate;

    /***************************************** feign *****************************************/
    /**
     * feign 接口示例
     * 参考：https://www.cnblogs.com/jingzh/p/16820530.html
     *
     * @return
     */
    @ApiOperation(value = "feign")
    @GetMapping("/feign")
    public ResponseResult<String> feign() {
        return schSpringbootService.asyncMethod(LogUtil.getRequestId());
    }

    /***************************************** hystrix *****************************************/
    /**
     * 参考：https://www.cnblogs.com/shigongp/p/17280398.html
     */
    @ApiOperation(value = "hystrix")
    @GetMapping("/hystrix")
    @HystrixCommand(fallbackMethod = "error")
    public ResponseResult<String> hystrix() {

        int a = 10 / 0; //除数是不能为0的，会抛出运行时异常

        return ResponseResult.success("hystrix");
    }

    @ApiOperation(value = "restControllerAdvice")
    @GetMapping("/restControllerAdvice")
    public ResponseResult<String> restControllerAdvice() {

        int a = 10 / 0; //除数是不能为0的，会抛出运行时异常

        return ResponseResult.success("restControllerAdvice");
    }

    /**
     * 熔断的回调方法，也就是降级方法
     *
     * @return
     */
    public ResponseResult<String> error() {
        log.error("hystrix error");

        //访问远程服务失败，该如何处理？这些处理逻辑就可以写在该方法中
        return ResponseResult.fail("hystrix");
    }

    /***************************************** RestTemplate *****************************************/

    @ApiOperation(value = "restTemplate")
    @GetMapping("/restTemplate")
    public ResponseResult restTemplate() {
        ResponseResult responseResult = restTemplate.getForObject("http://192.168.50.133:9009/demo/responseResult", ResponseResult.class);

        // UnknownHostException
//        ResponseResult responseResult = restTemplate.getForObject("http://sch-springboot/demo/responseResult", ResponseResult.class);

        return responseResult;
    }

    /**
     * restTemplate 带请求头
     */
    @ApiOperation(value = "restTemplateHeader")
    @GetMapping("/restTemplateHeader")
    public ResponseResult restTemplateHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("requestId", LogUtil.getRequestId());
        HttpEntity<ResponseResult> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<ResponseResult> response = restTemplate.exchange(
                "http://192.168.50.133:9009/demo/responseResult",
                HttpMethod.GET, requestEntity,
                ResponseResult.class);
        ResponseResult responseResult = response.getBody();

        return responseResult;
    }

    @ApiOperation(value = "loadBalancedRestTemplate")
    @GetMapping("/loadBalancedRestTemplate")
    public ResponseResult loadBalancedRestTemplate() {
        ResponseResult responseResult = loadBalancedRestTemplate.getForObject("http://sch-springboot/demo/responseResult", ResponseResult.class);

        // No instances available
//        ResponseResult responseResult = loadBalancedRestTemplate.getForObject("http://192.168.50.133:9009/demo/responseResult", ResponseResult.class);

        return responseResult;
    }

}
