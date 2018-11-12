package com.env.democlient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

@SpringBootApplication
@EnableDubbo
public class Dubboclient01Application {

	public static void main(String[] args) {
		SpringApplication.run(Dubboclient01Application.class, args);
	}
}
