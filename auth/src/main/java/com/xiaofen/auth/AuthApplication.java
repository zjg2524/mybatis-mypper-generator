package com.xiaofen.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class AuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}

	@GetMapping("/")
	public String testInit()
	{
		return "springboot ok...............";
	}

	@GetMapping("/hello")
	public String testhello()
	{
		return "hello world...............";
	}
}
