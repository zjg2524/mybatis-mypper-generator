package com.atguigu.mapper.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.mapper.entities.User;
import com.atguigu.mapper.mappers.UserMapper2;

@Service
public class UserService2 {
	
	@Autowired
	UserMapper2 userMapper2;
	

	public User selectUser(int s2id)

	{
		return userMapper2.selectUserOneById(sid);
	}
	
	
}
