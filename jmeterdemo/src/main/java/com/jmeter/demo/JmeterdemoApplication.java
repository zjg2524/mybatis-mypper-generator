package com.jmeter.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "com.jmeter.demo.dao")
@SpringBootApplication
@RestController
public class JmeterdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JmeterdemoApplication.class, args);
	}


	@RequestMapping("/")
	public String home()
	{
		return "spring boot security demo home.....";
	}

	@GetMapping("/hello")
    public String hello()
    {
        return "hello....";
    }

}
