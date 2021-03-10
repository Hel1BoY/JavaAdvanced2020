package com.example.GameStore.repo;

import com.example.GameStore.model.Developer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DeveloperRepo extends CrudRepository<Developer, Long> {

    Optional<Developer> findByPostcode(String postcode);
    Optional<Developer> findByName(String name);
 

}
