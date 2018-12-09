package com.example1207.api.service;

import com.example1207.api.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 2018/12/8
 * Administrator
 * com.example1207.provider8001.service
 */
//@FeignClient("MICROSERVICECLOUDDEPT")
    @FeignClient(value = "MICROSERVICECLOUDDEPT",fallbackFactory = UserServiceFactory.class)
public interface UserConsumerService {


    @GetMapping("/users/all/{id}")
    User getUsers(@PathVariable("id") int id);

}
