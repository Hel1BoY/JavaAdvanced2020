package com.example.GameStore.service;

import com.example.GameStore.model.Developer;
import com.example.GameStore.repo.DeveloperRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeveloperServiceImpl implements DeveloperService{

    @Autowired
    private DeveloperRepo developerRepo;

    @Override
    public Developer updateDevName(String newName, Developer developer) throws IllegalArgumentException{
        developer.setName(newName);
        return saveDeveloper(developer);
    }

    @Override
    public Developer getById(Long id) {
        return developerRepo.findById(id).get();
    }

    @Override
    public Developer getByPostcode(String postcode) {
        return developerRepo.findByPostcode(postcode).get();
    }

    @Override
    public Developer getByName(String name) {
        return developerRepo.findByName(name).get();
    }

    @Override
    public Developer saveDeveloper(Developer developer) throws IllegalArgumentException{
        checkPropertiesForSaving(developer);
        return developerRepo.save(developer);
    }

    @Override
    public void checkPropertiesForSaving(Developer developer) throws IllegalArgumentException{
        if (developer.getName() == null || developer.getName().matches("\\s{0,}") ||
                developer.getCountry() == null || developer.getCountry().matches("\\s{0,}") ||
                developer.getPostcode() == null || developer.getPostcode().matches("\\s{0,}")) {
            throw new IllegalArgumentException();
        }
    }


}
