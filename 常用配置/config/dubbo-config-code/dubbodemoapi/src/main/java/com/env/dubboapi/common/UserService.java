package com.env.dubboapi.common;

import com.env.dubboapi.entity.User;

public interface UserService {
    // 根据ID获取用户
    public User getUser(int sid);
    
    // 增加用户
    public String addUser(User user);

}
