package com.example1207.provider8001.controlr;

import com.example1207.api.entity.User;
import com.example1207.api.service.UserConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 2018/12/7
 * Administrator
 * com.example1207.provider8001.controlr
 */
@RestController
@RequestMapping("/consumers")
public class UserController {



    @Autowired(required = false)
    UserConsumerService userConsumerService;

    @GetMapping("/all")
    public User getAll() {
        User users = userConsumerService.getUsers();
        return users;

    }
    @GetMapping("/a1")
    public String getAll2() {

        return "getAll2";
    }

}
