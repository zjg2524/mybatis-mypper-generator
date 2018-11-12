package com.env.dubbodemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

@SpringBootApplication
@EnableDubbo
public class DubboserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(DubboserverApplication.class, args);
	}
}
