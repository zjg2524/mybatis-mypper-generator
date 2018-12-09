package com.example1207.provider8001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableEurekaClient
//@EnableFeignClients
public class Consumer82Application {


	public static void main(String[] args) {
		SpringApplication.run(com.example1207.api.Consumer82Application.class, args);
	}
}
