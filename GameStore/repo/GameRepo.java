package com.example.GameStore.repo;

import com.example.GameStore.model.Game;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GameRepo extends CrudRepository<Game, Long> {

    Optional<Game> findByName(String name);
    Optional<Game> findByIsbn(String isbn);
    Optional<Game> findByGenre(String genre);
    Optional<Game> findById(Long id);

}
