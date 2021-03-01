package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	private List<String> names = new LinkedList<String>();

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name" , defaultValue = "World") String name){
		names.add(name);
		return "Hello " + names;

	}

	@GetMapping("/dog")
	public Dog getDog (@RequestParam String name, @RequestParam int age){
		Dog dog = new Dog();
		dog.setName(name);
		dog.setAge(age);

		return dog;

	}

}
