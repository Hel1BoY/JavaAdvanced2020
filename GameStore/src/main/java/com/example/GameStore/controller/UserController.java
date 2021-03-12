package com.example.GameStore.controller;

import com.example.GameStore.model.User;
import com.example.GameStore.service.OrderService;
import com.example.GameStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;


@RestController
@RequestMapping("/api/v1/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;
    
    @GetMapping("username")
    public @ResponseBody User getByUsername(@RequestParam String username){
        try{
            return userService.getByUsername(username);
        }catch (NoSuchElementException e){
            throw new NoSuchElementException();
        }

    }

    @GetMapping("email")
    public @ResponseBody User getByEmail(@RequestParam String email){
        try{
            return userService.getByEmail(email);
        }catch (NoSuchElementException e){
            throw new NoSuchElementException();
        }
    }
    
    @DeleteMapping("delete{id}")
    public @ResponseBody void deleteUser(@PathVariable Long id){
        try{
            userService.deleteUser(id);
        }catch (NoSuchElementException e){
            throw new NoSuchElementException();
        }
    }

    @PostMapping("")
    public User saveUser(@RequestBody User user){
        try {
            return userService.saveUser(user);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
    }

    @PutMapping("user{id}")
    public User updateUsername(@RequestBody User user, @PathVariable Long id) {
        try {
            userService.getById(id);
            return userService.updateUsername(user, user.getUsername());
        }catch (NoSuchElementException e){
            throw new NoSuchElementException();
        }
    }
    

}
