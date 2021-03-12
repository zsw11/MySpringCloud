package com.zsw.provider.service.impl;

import com.github.pagehelper.PageHelper;
import com.zsw.provider.entity.model.User;
import com.zsw.provider.mapper.UserMapper;
import com.zsw.provider.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zsw
 * @date 2021/3/8 13:45
 * @description :
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        int i = userMapper.addUser(user); //这里可以直接传对象
        return user.getId(); //返回新增数据的id
    }

    @Override
    public int update(User user) {
        userMapper.updateUser(user);
        return user.getId();

    }

    @Override
    public int delete(int id) {
        int delete = userMapper.delete(id);
        return delete;
    }

    @Override
    public List<User> get(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
       return userMapper.get();
    }
}
