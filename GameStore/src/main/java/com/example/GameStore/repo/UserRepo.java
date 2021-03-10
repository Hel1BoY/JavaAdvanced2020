package com.example.GameStore.repo;

import com.example.GameStore.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepo extends CrudRepository<User,Long> {

    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);


}
