package com.jmeter.demo.controller;

import com.jmeter.demo.entity.Orders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2019/3/14
 * Administrator
 * com.jmeter.demo.controller
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @PostMapping("/test")

    public String orderTest(Orders orders){
        System.out.println(orders);
        return orders.toString();
    }
}
