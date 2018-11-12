package com.env.dubbodemo.service;

import org.springframework.stereotype.Service;

import com.env.dubboapi.common.UserService;
import com.env.dubboapi.entity.User;

@Service
@com.alibaba.dubbo.config.annotation.Service(version="1.0.0",timeout=3000,retries=0,owner = "zhangjingui",loadbalance = "roundrobin",actives = 2)
public class UserServiceImpl implements UserService {

    @Override
    public User getUser(int sid) {
       User user = new User();
       user.setSname("yyc");
       user.setPwd("eclipse1");
       user.setSid(sid);
       
        return user;
    }

    @Override
    public String addUser(User user) {
        System.out.println(user);
        return "success";
    }

}
