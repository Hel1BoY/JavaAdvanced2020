package com.example.demo.calculator;

import lombok.extern.slf4j.Slf4j;
import org.apache.xpath.operations.String;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Collection;

@ComponentScan
@SpringBootApplication
public class CalculatorApplication {


    public static void man(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(CalculatorApplication.class, java.lang.String.valueOf(args));
        var calculator = ctx.getBean(Calculator.class);
        calculator.calculate(137, 21, '+');
        calculator.calculate(137, 21, '*');
        calculator.calculate(137, 21, '-');


    }






















    /*@Bean
    public ApplicationRunner calculationRunner(Calculator calculator) {
        calculator.calculate(5,3, '+');
        return args -> {

        };
    }*/
}
