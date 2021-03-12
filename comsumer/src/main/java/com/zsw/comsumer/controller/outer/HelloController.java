package com.zsw.comsumer.controller.outer;

import com.zsw.comsumer.service.SyaHelloService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author zsw
 * @date 2021/3/10 17:35
 * @description : 测试 hello
 */
@RestController
public class HelloController {

    // 服务名
    @Value("${provider01}")
    private static final String REST_URL_PRE = "";

    // 基于Feign 测试
    @Resource
    private SyaHelloService syaHelloService;

    // 基于 Ribbon 测试
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("feign/hello")
    public String sayHello(){
        return syaHelloService.sayHello();
    }

    @GetMapping("ribbon/hello")
    public String sayHelloRest(){
        return restTemplate.getForObject(REST_URL_PRE + "/hello",String.class);
    }
}
