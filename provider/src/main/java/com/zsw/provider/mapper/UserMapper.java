package com.zsw.provider.mapper;

import com.zsw.provider.entity.model.User;

import java.util.List;

/**
 * @author zsw
 * @date 2021/3/12 13:50
 * @description :
 */
public interface UserMapper {

    int addUser(User user);

    int updateUser(User user);

    int delete(int id);

    List<User> get();
}
