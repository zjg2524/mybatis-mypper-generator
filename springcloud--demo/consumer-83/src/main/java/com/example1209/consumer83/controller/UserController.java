package com.example1209.consumer83.controller;

import com.example1207.api.entity.User;
import com.example1207.api.service.UserConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2018/12/9
 * Administrator
 * com.example1209.consumer83.controller
 */
@RequestMapping("/consumers")
@RestController
public class UserController {

    @Autowired
    UserConsumerService userConsumerService;

    @GetMapping("/all/{id}")
    public User getAll(@PathVariable("id") int id)
    {
        return userConsumerService.getUsers(id);
    }


    @GetMapping("/a1")
    public String getUsers(){
        return "consumers-83 --> a1..";
    }
}
