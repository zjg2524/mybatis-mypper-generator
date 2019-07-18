package com.jmeter.demo.dao;

import com.jmeter.demo.entity.Users;

import java.util.List;

/**
 * 2018/11/26
 * Administrator
 * com.jmeter.demo.dao
 */
public interface UserMapper2 {

    public List<Users> selectUserAndOrderAll(int id);
}
