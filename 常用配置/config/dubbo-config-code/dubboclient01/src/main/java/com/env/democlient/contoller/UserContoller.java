package com.env.democlient.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.env.dubboapi.common.UserService;
import com.env.dubboapi.entity.User;

@RestController
@RequestMapping("/user")
public class UserContoller {

    @Reference(version="1.0.0",check=false)
    UserService userService;
    
    @GetMapping("/query/{sid}")
    public User getUserById(@PathVariable("sid")int sid)
    {
        User user = userService.getUser(sid);
        System.out.println(user);
        return user;
    }
}
