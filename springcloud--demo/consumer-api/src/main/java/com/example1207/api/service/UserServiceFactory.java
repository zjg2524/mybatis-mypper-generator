package com.example1207.api.service;

import com.example1207.api.entity.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 2018/12/9
 * Administrator
 * com.example1207.api.service
 */
@Component
public class UserServiceFactory implements FallbackFactory<UserConsumerService> {
    @Override
    public UserConsumerService create(Throwable throwable) {
        return new UserConsumerService() {
            @Override
            public User getUsers(int id) {
                User user = new User();
                user.setSid(8003);
                user.setSname("service hystrix....");
                return user;
            }
        };
    }
}
