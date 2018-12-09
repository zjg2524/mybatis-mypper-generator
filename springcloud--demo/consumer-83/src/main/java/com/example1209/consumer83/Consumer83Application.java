package com.example1209.consumer83;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @EnableFeignClients basePackages必须要要扫描到API中的接口com.example1207.api ！！！！
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.example1207.api.service","com.example1209.consumer83.controller"})
@ComponentScan(basePackages = {"com.example1209.consumer83","com.example1207.api"})
public class Consumer83Application {

	public static void main(String[] args) {
		SpringApplication.run(Consumer83Application.class, args);
	}
}
