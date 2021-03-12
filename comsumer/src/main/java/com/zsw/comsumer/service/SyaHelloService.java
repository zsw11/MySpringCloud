package com.zsw.comsumer.service;

import com.zsw.comsumer.service.hystric.SayHelloServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author zsw
 * @date 2021/3/10 17:29
 * @description :
 */
@Service
@FeignClient(value = "provider01",fallback = SayHelloServiceHystrix.class) //调用的服务名称
public interface SyaHelloService {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String sayHello();
}
