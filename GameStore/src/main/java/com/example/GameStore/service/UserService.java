package com.example.GameStore.service;

import com.example.GameStore.model.User;
import org.springframework.stereotype.Service;

/**
 * UserService to handle CRUD request for Game store.
 */

@Service
public interface UserService {

    /**
     *
     * @param id
     * @return
     */
    User getById(Long id);

    /**
     *
     * @param username
     * @return
     */
    User getByUsername(String username);

    /**
     *
     * @param email
     * @return
     */
    User getByEmail(String email);

    /**
     *
     * @param user
     * @return
     */
    User saveUser(User user) throws IllegalArgumentException;

    /**
     *
     * @param user
     * @return
     */
    User updateUsername(User user, String username);

    /**
     *
     * @param id
     */
    void deleteUser(Long id);

    /**
     *
     * @param user
     */
    void checkProperties(User user) throws IllegalArgumentException;

}
