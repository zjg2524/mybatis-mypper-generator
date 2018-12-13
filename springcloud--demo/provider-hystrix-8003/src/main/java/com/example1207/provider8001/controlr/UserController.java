package com.example1207.provider8001.controlr;

import com.example1207.provider8001.dao.UserJpa;
import com.example1207.provider8001.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * 2018/12/7
 * Administrator
 * com.example1207.provider8001.controlr
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserJpa userJpa;

    @GetMapping("/all/{id}")
    @HystrixCommand(fallbackMethod = "testHystrixMeth")
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "30000")
//    })
    public User getAll(@PathVariable("id") int id)
    {
        Optional<User> byId = userJpa.findById(id);
        User user = byId.get();
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        user.setSid(8003);
        if(user == null){
            System.out.println("enter exception........");
            throw new RuntimeException("数据不存在！！！！！！！");
        }
        return user;
    }

    public User testHystrixMeth(@PathVariable("id") int id){
        User user = new User();
        user.setSid(8003);
        user.setSname(id+"用户信息不存在！！！！");
        return user;

    }
}
