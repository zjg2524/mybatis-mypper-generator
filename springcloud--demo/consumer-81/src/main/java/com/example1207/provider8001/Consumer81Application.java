package com.example1207.provider8001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Consumer81Application {


	public static void main(String[] args) {
		SpringApplication.run(Consumer81Application.class, args);
	}
}
