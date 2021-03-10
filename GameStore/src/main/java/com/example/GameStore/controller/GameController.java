package com.example.GameStore.controller;

import com.example.GameStore.model.Developer;
import com.example.GameStore.model.Game;
import com.example.GameStore.service.DeveloperService;
import com.example.GameStore.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/game/")
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private DeveloperService developerService;

    @PostMapping("save")
    public @ResponseBody
    Game saveGame(@RequestBody Game game) {
        try {
            return gameService.saveGame(game);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
    }

    @PutMapping("update/price/{id}")
    public synchronized @ResponseBody
    Game updatePrice(@RequestBody Game game, @PathVariable Long id) {
        try {
            gameService.getById(id);
            return gameService.updatePrice(game, game.getPrice());
        }catch (NoSuchElementException e){
            throw new NoSuchElementException();
        }
    }

    @GetMapping("get/name")
    public @ResponseBody Game getByName(@RequestParam String name){
        try {
            return gameService.getByName(name);
        }catch (NoSuchElementException e){
            throw new NoSuchElementException();
        }
    }

    @GetMapping("get/isbn")
    public @ResponseBody Game getByIsbn(@RequestParam String isbn){
        try {
            return gameService.getByIsbn(isbn);
        }catch (NoSuchElementException e){
            throw new NoSuchElementException();
        }
    }


}
