package com.atguigu.mapper.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atguigu.mapper.entities.User;
import com.atguigu.mapper.services.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring-context.xml"})
public class UserMapperTest {

	@Autowired
	UserService userService;
	
	
	@Test
	public void test()
	{
		List<User> users = userService.getUser();
		
		System.out.println(users);
	}
	
	
	@Test
	public void testSelectUserByExample()
	{
		List<User> users = userService.selectUserByExample();
		System.out.println(users);
	}
}
