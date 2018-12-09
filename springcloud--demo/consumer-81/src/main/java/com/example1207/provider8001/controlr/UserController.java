package com.example1207.provider8001.controlr;

import com.example1207.provider8001.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 2018/12/7
 * Administrator
 * com.example1207.provider8001.controlr
 */
@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;
    private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";
//    private static final String REST_URL_PREFIX = "http://localhost:8001";

    @GetMapping("/consumers/all")
    public User getAll() {

        User user = restTemplate.getForObject(REST_URL_PREFIX + "/users/all", User.class);

        return user;
    }
}
