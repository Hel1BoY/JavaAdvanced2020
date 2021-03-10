package com.example.GameStore.service;


import com.example.GameStore.model.Game;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;


/**
 * Video game service to handle CRUD request for Game store.
 */

@Service
public interface GameService {

    /**
     *
     * @param id
     * @return
     */
    Game getById(Long id);

    /**
     *
     * @param name
     * @return
     */
    Game getByName(String name) throws NoSuchElementException;

    /**
     *
     * @param isbn
     * @return
     */
    Game getByIsbn(String isbn);

    /**
     *
     * @param genre
     * @return
     */
    Game getByGenre(String genre);

    /**
     *
     * @param game
     * @param price
     * @return
     */
    Game updatePrice(Game game, Double price);

    /**
     *
     * @param game
     * @return
     */
    Game saveGame(Game game);

    /**
     *
     * @param id
     */
    void deleteGame(Long id);

    /**
     *
     * @param game
     */
    void checkProperties(Game game) throws IllegalArgumentException;

}
