package com.zsw.comsumer.controller.outer;

import com.zsw.comsumer.entity.ResultResp;
import com.zsw.comsumer.entity.model.User;
import com.zsw.comsumer.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zsw
 * @date 2021/3/8 11:41
 * @description : user  调用内部api时，返回结果是服务提供方的返回结果，注意返回类型要一致，服务已经写好，
 */
@RestController("/user")
@Api("用户信息 调用内部api")
public class UserController {

    @Resource
    private UserService UserService;

    @ApiOperation(value = "添加用户")
    @PostMapping("/add")
    public ResultResp addUser(@Validated @RequestBody User user) {
        // 返回插入数据的id
        return UserService.addUser(user);
    }

    @ApiOperation("更新用户")
    @PutMapping("/update")
    public ResultResp updateUser(@Validated @RequestBody User user) {
        return UserService.update(user);
    }

    @ApiOperation("删除用户")
    @ApiImplicitParam(name = "id",value = "用户id")
    @DeleteMapping("/delete/{id}")
    public ResultResp deleteUser(@PathVariable int id) {
        return UserService.delete(id);
    }

    @ApiOperation("分页获取用户")
    @GetMapping("/get")
    public ResultResp getUser(@RequestParam int pageNum, @RequestParam int pageSize) {
        return UserService.get(pageNum,pageSize);
    }

}
