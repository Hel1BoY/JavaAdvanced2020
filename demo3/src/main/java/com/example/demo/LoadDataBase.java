package com.example.demo;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDataBase {

    @Bean
    public CommandLineRunner initData(EmployeeRepository employeeRepository){
        return args -> {
            employeeRepository.save(new Employee("User1","Role1"));
            employeeRepository.save(new Employee("User2","Role2"));
            employeeRepository.save(new Employee("User3","Role3"));

        };

    }


}
