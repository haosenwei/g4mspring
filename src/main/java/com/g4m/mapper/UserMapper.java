package com.g4m.mapper;


import com.g4m.base.BaseMapper;
import com.g4m.entity.User;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * @Description
 * @Author sgl
 * @Date 2018-05-02 15:02
 */
public interface UserMapper extends BaseMapper<User> {
    Page<User> getUsers();
}
