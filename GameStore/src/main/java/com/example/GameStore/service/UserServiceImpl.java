package com.example.GameStore.service;

import com.example.GameStore.model.User;
import com.example.GameStore.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Override
    public User getById(Long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public User getByUsername(String username) {
        return userRepo.findByUsername(username).get();
    }

    @Override
    public User getByEmail(String email) {
        return userRepo.findByEmail(email).get();
    }

    @Override
    public User saveUser(User user) throws IllegalArgumentException{
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        checkProperties(user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public User updateUsername(User user, String username) {
        user.setUsername(username);
        userRepo.save(user);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public void checkProperties(User user) throws IllegalArgumentException{

        if(user.getUsername() == null || user.getUsername().isBlank() ||
                user.getPassword() == null || user.getPassword().isBlank() ||
                user.getEmail() == null || !user.getEmail().matches("[A-Z]*[a-z]+[1-9]*@[a-z]+\\.[a-z]+") ||
                user.getRole() == null  || !(user.getRole().toLowerCase().equals("admin") ||
                                             user.getRole().toLowerCase().equals("user")) )
        {
            throw new IllegalArgumentException();
        }
    }
}
