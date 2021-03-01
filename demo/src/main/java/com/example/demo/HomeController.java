package com.example.demo;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Profile("dev")
public class HomeController {

    @ApiResponses(value =
            {
                    @ApiResponse(responseCode = "205",description = "It's okay"),
                    @ApiResponse(responseCode = "403",description = "Error!")
            })

    @GetMapping("/health")
    public @ResponseBody String test(@RequestParam String test){
        return "Hello World!";
    }
}
