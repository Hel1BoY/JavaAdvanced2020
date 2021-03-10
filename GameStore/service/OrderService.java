package com.example.GameStore.service;

import com.example.GameStore.model.Order;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Order service to handle CRUD request for Game store.
 */

@Service
public interface OrderService {

    /**
     *
     * @param id
     * @return
     */
    Optional<Order> getOrder(Long id);

    /**
     * @param username
     * @param gameName
     * @param quantity
     * @return
     */
    Order placeOrder(String username, String gameName, Integer quantity);

    /**
     *
     * @param id
     * @return
     */
    void declineOrder(Long id);

    void checkProperties(String username, String gamename, Integer quantity);

}
