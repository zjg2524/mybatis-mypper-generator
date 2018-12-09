package com.example1207.provider8001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Provider8002Application {

	public static void main(String[] args) {
		SpringApplication.run(Provider8002Application.class, args);
	}
}
