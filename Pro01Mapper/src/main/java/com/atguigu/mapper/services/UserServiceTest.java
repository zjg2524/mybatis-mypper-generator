package com.atguigu.mapper.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.mapper.entities.User;

public class UserServiceTest {
	private ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("spring-context.xml");
	private UserService userService = ioc.getBean(UserService.class);
	@Test
	public void testGetUser() {
		List<User> users = userService.getUser();
		System.out.println(users);
	}
	
	@Test
	public void selectOneByUserTest() {
		User user = new User();
		user.setS_name("huahua");;
		User userResult = userService.selectOneByUser(user);
		System.out.println(userResult);
	}
	
	@Test
	public void testInsertUser()
	{
		userService.insertUser();
	}

}
