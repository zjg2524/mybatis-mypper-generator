package com.jmeter.demo.controller;

import com.jmeter.demo.entity.User;
import com.jmeter.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 2018/10/9
 * Administrator
 * com.jmeter.demo.controller
 */
@RestController
@RequestMapping("/jmeter")
public class TestController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List <User> queryUserAll()
    {
        return userService.getUserById();
    }
}
