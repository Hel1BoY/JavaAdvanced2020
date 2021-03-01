package com.example.mock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@WebMvcTest(HomeController.class)
public class HomeController {

    @Autowired
    HomeService homeService;

    @MockBean
    private HomeService service;

    @GetMapping("/")
    public @ResponseBody String test(){
        return homeService.print();
    }

}
