package com.atguigu.mapper.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.mapper.entities.User;
import com.atguigu.mapper.mappers.UserMapper;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;
@Service
public class UserService {
	
	@Autowired
	UserMapper userMapper;
	
	public List<User> getUser()
	{
		List<User> userList = userMapper.selectAll();
		System.out.println(userList);
		
		return userList;
	}

	
	public User selectOneByUser(User user)
	{
		return userMapper.selectOne(user);
	}
	
	public List<User> selectUserByExample()
	{
		//1.创建example对象
		Example example = new Example(User.class);
		example.setDistinct(true);
		example.selectProperties("sid","s_name");
		
		//2.通过example对象，创建criteria对象
		Criteria criteria = example.createCriteria();
		
		//3.封装查询条件
		criteria.andGreaterThan("sid", 2).andEqualTo("s_name", "huahua");
		
		//4.执行查询
		List<User> users = userMapper.selectByExample(example);
		return users;
	}
	
	public void insertUser()
	{
		User user = new User();
		user.setSid(22+"");
		user.setS_name("xiaofeng");
		user.setSaddr("ey");
		user.setSphone("1523628");
		int insert = userMapper.insert(user);
		System.out.println(insert);
	}
}
