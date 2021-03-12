package com.example.GameStore.controller;

import com.example.GameStore.model.Order;
import com.example.GameStore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/order/")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @DeleteMapping("decline/{id}")
    public void declineOrder(@PathVariable Long id) {
        try {
            orderService.declineOrder(id);
        }catch (NoSuchElementException e){
            throw new NoSuchElementException();
        }

    }
    
    @PostMapping("")
    public @ResponseBody Order placeOrder(@RequestParam String username, @RequestParam String gameName, @RequestParam Integer quantity){
        return orderService.placeOrder(username,gameName,quantity);
    }

}
