package com.example.GameStore.service;

import com.example.GameStore.model.Game;
import com.example.GameStore.repo.GameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepo gameRepo;

    @Autowired
    private DeveloperService developerService;

    @Override
    public Game getById(Long id) {
        return gameRepo.findById(id).get();
    }

    @Override
    public Game getByName(String name) throws NoSuchElementException{
        return gameRepo.findByName(name).get();
    }

    @Override
    public Game getByIsbn(String isbn) {
        return gameRepo.findByIsbn(isbn).get();
    }

    @Override
    public Game getByGenre(String genre) {
        return gameRepo.findByGenre(genre).get();
    }

    @Override
    public Game updatePrice(Game game, Double price) {
        game.setPrice(price);
        return gameRepo.save(game);
    }

    public Game saveGame(Game game) throws IllegalArgumentException{
        checkProperties(game);
        return gameRepo.save(game);
    }

    @Override
    public void deleteGame(Long id) {
        gameRepo.deleteById(new GameServiceImpl().getById(id).getId());
    }

    @Override
    public void checkProperties(Game game) throws IllegalArgumentException{
        //check if developer's properties are valid
            if(game.getDeveloper() != null) {
                //developerService.checkProperties(game.getDeveloper());
            }else{
                throw new IllegalArgumentException();
            }

        //check if the rest of game's properties are valid
            if (game.getName() == null || game.getName().matches("\\s{0,}") ||
                    game.getIsbn() == null || game.getIsbn().matches("\\s{0,}") ||
                    game.getQuantity() == null || game.getQuantity() <= 0 ||
                    game.getPrice() == null || game.getPrice() < 0 ||
                    game.getGenre() == null || game.getGenre().matches("\\s{0,}") ||
                    game.getReleaseYear() == null || game.getReleaseYear() < 2000){

                throw new IllegalArgumentException();
            }


    }

}
