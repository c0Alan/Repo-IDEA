package com.springmvc.controller;

import org.apache.cxf.configuration.security.ProxyAuthorizationPolicy;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/ws")
@Controller
public class WebServiceTest {

    @RequestMapping("/helloWorld")
    public String helloWorld(){
        return "success";
    }

    @RequestMapping("/testPersonService")
    public String testPersonService() throws Exception {
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("classpath:PersonService.wsdl");
        Object[] res = client.invoke("sayHello", "tom");
        System.out.println(res[0]);
        return "success";
    }
}
