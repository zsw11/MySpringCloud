package com.zsw.provider.controller.inner;


import com.zsw.provider.entity.ResultResp;
import com.zsw.provider.entity.model.User;
import com.zsw.provider.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zsw
 * @date 2021/3/8 11:41
 * @description : user
 */
@RestController("/user")
@Api("用户信息")
public class UserController {

    @Resource
    private UserService UserService;

    @ApiOperation(value = "添加用户")
    @PostMapping("/add")
    public ResultResp addUser(@Validated @RequestBody User user, BindingResult bingingResult) { //@Validated 表示检验User 对象， BindingResult 表示检验出错是保存的错误信息,BindingResult 要跟在实体类之后,
        ArrayList<String> result = new ArrayList<>();
        if(bingingResult.hasErrors()){
            List<ObjectError> allErrors = bingingResult.getAllErrors();
            for(ObjectError error: allErrors ){
                result.add(error.getDefaultMessage());
            }
            return ResultResp.fail(result);
        }
        // 返回插入数据的id
        int id = UserService.addUser(user);
        if (id > 0) {
            return ResultResp.success(id);
        }
        return ResultResp.fail(id);
    }

    @ApiOperation("更新用户")
    @PutMapping("/update")
    public ResultResp updateUser(@Validated @RequestBody User user) {
        int update = UserService.update(user);
        if (update > 0) {
            return ResultResp.success(update);
        }
        return ResultResp.fail("更新失败");
    }

    @ApiOperation("删除用户")
    @ApiImplicitParam(name = "id",value = "用户id")
    @DeleteMapping("/delete/{id}")
    public ResultResp deleteUser(@PathVariable int id) {
        int delete = UserService.delete(id);
        if (delete > 0) {
            return ResultResp.success(delete);
        }
        return ResultResp.fail("没有这个用户");
    }

    @ApiOperation("分页获取用户")
    @GetMapping("/get")
    public ResultResp getUser(@RequestParam int pageNum, @RequestParam int pageSize) {
        List<User> userList = UserService.get(pageNum,pageSize);
        return ResultResp.success(userList);
    }

}
