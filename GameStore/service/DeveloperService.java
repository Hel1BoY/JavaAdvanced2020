package com.example.GameStore.service;

import com.example.GameStore.model.Developer;
import org.springframework.stereotype.Service;


/**
 * Developer service to handle CRUD request for Game store.
 */

@Service
public interface DeveloperService {


    Developer updateDevName(String newName, Developer developer);

    /**
     * @param id
     * @return
     */
    Developer getById(Long id);

    /**
     * @param postcode
     * @return
     */
    Developer getByPostcode(String postcode);

    /**
     * @param name
     * @return
     */
    Developer getByName(String name);

    /**
     * @param developer
     * @return
     */
    Developer saveDeveloper(Developer developer) throws IllegalArgumentException;

    /**
     *
     * @param developer
     * @throws IllegalArgumentException
     */
    void checkPropertiesForSaving(Developer developer) throws IllegalArgumentException;


}
