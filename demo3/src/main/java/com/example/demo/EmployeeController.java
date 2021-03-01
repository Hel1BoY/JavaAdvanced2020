package com.example.demo;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    /*
      GET /employees
      GET /employees/{id}
      POST /employees

      Delete /employees/{id}

      PUT /employees/{id}
     */

    @GetMapping("/employees")
    public List<Employee> all(){
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee one(@PathVariable Long id){


        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @PostMapping("/employees")
    public Employee newEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void delete(@PathVariable Long id){
        employeeRepository.deleteById(id);
    }

    @PutMapping("/employees/{id}")
    public Employee editEmployee(@RequestBody Employee employee, @PathVariable Long id){
        return employeeRepository.findById(id)
                .map(loadEmployee -> {
                    loadEmployee.setName(loadEmployee.getName());
                    loadEmployee.setRole(loadEmployee.getRole());
                    return employeeRepository.save(loadEmployee);
                }).orElseGet(() -> {
                    return employeeRepository.save(employee);
                });
    }

}
