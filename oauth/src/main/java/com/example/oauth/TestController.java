package com.example.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class TestController {

    @Autowired
    Github github;

    @GetMapping("/test")
    public String test(@RequestParam(defaultValue = "Hel1BoY") String name){
        System.out.println(github.toString());
        return Arrays.toString(github.getRepos(name));
    }

}
