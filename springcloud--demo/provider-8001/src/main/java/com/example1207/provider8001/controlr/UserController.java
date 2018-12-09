package com.example1207.provider8001.controlr;

import com.example1207.provider8001.dao.UserJpa;
import com.example1207.provider8001.entity.User;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/all")
    public User getAll()
    {
        Optional<User> byId = userJpa.findById(23);
        User user = byId.get();
        user.setSid(8001);
        return user;
    }
}
