package com.example.demo;

import com.example.demo.calculator.Calculator;
import com.example.demo.test.Config;
import com.example.demo.test.Zoo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoApplication {

	@Autowired
	Calculator calculator;


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}



	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		calculator.calculate(3,6,'+');
		return String.format("Hello %s!", name);
	}
}
