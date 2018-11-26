package com.jmeter.demo.service;

import com.jmeter.demo.dao.UserMapper;
import com.jmeter.demo.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 2018/10/9
 * Administrator
 * com.jmeter.demo.service
 */

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public  List<Users> getUserById()
    {
        List<Users> users = userMapper.selectAll();
        return users;
    }
}
