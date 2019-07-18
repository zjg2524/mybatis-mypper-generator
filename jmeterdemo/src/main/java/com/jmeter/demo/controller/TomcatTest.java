package com.jmeter.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2018/12/27
 * Administrator
 * com.jmeter.demo.controller
 */
@RestController
@RequestMapping("/tomcat")
public class TomcatTest {


    @GetMapping("/test")
    public String test(){
        return "tomcat test.........";
    }
}
