package com.g4m.controller;

import com.g4m.entity.User;
import com.g4m.mapper.UserMapper;
import com.g4m.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description
 * @Author sgl
 * @Date 2018-05-02 14:59
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> lists() {
        return userService.getUsers();
    }

    @GetMapping("/user/{id}")
    public User one(@PathVariable("id") long id) {
        return userService.one(id);
    }
}
