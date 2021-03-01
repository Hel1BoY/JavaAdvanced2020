package com.example.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/create")
    public String create(){
        return "create";
    }

    @GetMapping("/delete")
    public String delete(){
        return "delete";
    }

}
