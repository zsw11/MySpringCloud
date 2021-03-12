package com.zsw.comsumer.service;

import com.zsw.comsumer.entity.ResultResp;
import com.zsw.comsumer.entity.model.User;
import com.zsw.comsumer.service.hystric.SayHelloServiceHystrix;
import com.zsw.comsumer.service.hystric.UserServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zsw
 * @date 2021/3/11 14:15
 * @description :  注意这里的返回值必须和 服务提供方的controller 一致
 */
@Service
@FeignClient(value = "provider01",fallback = UserServiceHystrix.class) //调用的服务名称
public interface UserService {
    /**
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping("/add")
    ResultResp addUser(@RequestBody User user);

    /**
     * 更新用户
     * @param user
     * @return
     */
    @PutMapping("/update")
    ResultResp update(@RequestBody User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    ResultResp delete(@PathVariable("id") int id);

    /**
     * 获取用户
     * @return
     */
    @GetMapping("/get")
    ResultResp get(@RequestParam int pageNum,@RequestParam int pageSize);

}

