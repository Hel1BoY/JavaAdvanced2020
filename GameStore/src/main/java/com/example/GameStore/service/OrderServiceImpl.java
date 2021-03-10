package com.example.GameStore.service;

import com.example.GameStore.model.Game;
import com.example.GameStore.model.Order;
import com.example.GameStore.model.User;
import com.example.GameStore.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private GameService gameService;

    @Override
    public Optional<Order> getOrder(Long id) {
        Optional<Order> foundOrder = orderRepo.findById(id);
        return foundOrder;
    }

    @Override
    public Order placeOrder(String username, String gameName, Integer quantity) {
        Game foundGame = gameService.getByName(gameName);
        User foundUser = userService.getByUsername(username);

        if(foundGame.getQuantity() >= quantity) {
            foundGame.setQuantity(foundGame.getQuantity() - quantity);
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There are not so many pieces left!");
        }

        Order order = new Order(foundUser, foundGame, quantity);
        return orderRepo.save(order);
    }

    @Override
    public void declineOrder(Long id) throws NoSuchElementException{
        try {
            orderRepo.deleteById(id);
        }catch (Exception e){
            throw new NoSuchElementException();
        }
    }

    @Override
    public void checkProperties(String username, String gamename, Integer quantity) {

    }


}
