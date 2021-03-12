package com.zsw.comsumer.service.hystric;

import com.zsw.comsumer.entity.ResultResp;
import com.zsw.comsumer.entity.model.User;
import com.zsw.comsumer.service.SyaHelloService;
import com.zsw.comsumer.service.UserService;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zsw
 * @date 2021/3/11 14:17
 * @description :
 */
@Component
public class UserServiceHystrix implements FallbackFactory<UserService> {
    @Override
    public UserService create(Throwable cause) {
        return new UserService() {

            @Override
            public ResultResp addUser(User user) {
                System.out.println("服务熔断");
                return null;
            }

            @Override
            public ResultResp update(User user) {
                System.out.println("服务熔断");
                return null;
            }

            @Override
            public ResultResp delete(int id) {
                System.out.println("服务熔断");
                return null;
            }

            @Override
            public ResultResp get(int pageNum,int pageSize) {
                System.out.println("服务熔断");
                return null;
            }
        };
    }
}
