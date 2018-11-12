package com.jmeter.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "com.jmeter.demo.dao")
@SpringBootApplication
public class JmeterdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JmeterdemoApplication.class, args);
	}



}
