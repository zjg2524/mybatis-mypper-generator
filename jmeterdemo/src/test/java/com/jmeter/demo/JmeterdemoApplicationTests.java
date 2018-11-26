package com.jmeter.demo;

import com.jmeter.demo.dao.OrdersMapper;
import com.jmeter.demo.dao.UserMapper2;
import com.jmeter.demo.entity.Orders;
import com.jmeter.demo.entity.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JmeterdemoApplicationTests {

	@Autowired
	UserMapper2 userMapper2;

	@Autowired
	OrdersMapper ordersMapper;
	@Test
	public void contextLoads() {

		List<Users> users = userMapper2.selectUserAndOrderAll(88);
		for (Users user : users) {
			System.out.println(user.getOrders().size());
		}
		System.out.println(users);
//		List<Orders> orders = ordersMapper.selectUserAndOrder2(200);
//		System.out.println(orders);
	}

}
