package com.example.demo;


import com.example.demo.calculator.Calculator;
import com.example.demo.test.Zoo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HomeController {

    @Autowired
    Calculator calculator;

    @Autowired
    Zoo zoo;

    @GetMapping("/")
    public String home(@Value("${test}")String test) {
        calculator.calculate(3,5,'+');
        System.out.println(test);
        zoo.getAnimal().toString();
        return "home";
    }

}