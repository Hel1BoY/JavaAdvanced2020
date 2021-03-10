package com.example.GameStore.controller;

import com.example.GameStore.model.Developer;
import com.example.GameStore.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/dev/")
public class DeveloperController {

    @Autowired
    private DeveloperService developerService;

    @PostMapping("save")
    public @ResponseBody
    Developer saveDev(@RequestBody Developer developer) throws IllegalArgumentException{
        try {
            return developerService.saveDeveloper(developer);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }

    }

    @PutMapping("update/name/{id}")
    public @ResponseBody Developer updateDevName(@RequestBody String newName, @PathVariable Long id) {
        try{
            return developerService.updateDevName(newName, developerService.getById(id));
        }catch (NoSuchElementException e){
            throw new NoSuchElementException();
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
    }

    @GetMapping("get/postcode")
    public @ResponseBody Developer getDevByPostCode(@RequestParam String postcode){
        try {
            return developerService.getByPostcode(postcode);
        }catch (NoSuchElementException e){
            throw new NoSuchElementException();
        }
    }

    @GetMapping("get/name")
    public @ResponseBody Developer getDevByName(@RequestParam String name){
        try {
            return developerService.getByName(name);
        }catch (NoSuchElementException e){
            throw new NoSuchElementException();
        }
    }


}

