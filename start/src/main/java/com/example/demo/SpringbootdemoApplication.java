package com.example.demo;

import com.example.demo.controller.TestController;
import com.example.demo.test.Test1Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@ComponentScan(value = "com.example.demo.dao")
public class SpringbootdemoApplication {


	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringbootdemoApplication.class,args);
	}

	@RequestMapping("/hello")
	public String sayHello() {
		return "hello, this is spring boot demo";
	}

}
