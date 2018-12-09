package com.example07.demo7001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Demo7001Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo7001Application.class, args);
	}
}
