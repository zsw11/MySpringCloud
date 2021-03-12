package com.zsw.comsumer.service.hystric;

import com.zsw.comsumer.service.SyaHelloService;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author zsw
 * @date 2021/1/28 16:38
 * @description :
 */
@Component
public class SayHelloServiceHystrix implements FallbackFactory<SyaHelloService> {

    @Override
    public SyaHelloService create(Throwable cause) {
        return new SyaHelloService() {
            @Override
            public String sayHello() {
                System.out.println("服务熔断");
                return "服务熔断";
            }
        };
    }
}
