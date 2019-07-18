package com.jmeter.demo;

import com.jmeter.demo.dao.UserMapper;
import com.jmeter.demo.demo.BlueColor;
import com.jmeter.demo.demo.IColor;
import com.jmeter.demo.demo.RedColor;
import com.jmeter.demo.entity.Users;
import com.jmeter.demo.service.UserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 2018/12/6
 * Administrator
 * com.jmeter.demo
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Import({RedColor.class, BlueColor.class})

public class Test {



}
