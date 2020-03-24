package com.example.demo;

import com.example.demo.resource.handler.ResourceFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootdemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoApplication.class,args);
		ResourceFactory resourceFactory = ResourceFactory.INSTANCE;
	}

	@RequestMapping("/hello")
	public String sayHello() {
		return "hello, this is spring boot demo";
	}

}
