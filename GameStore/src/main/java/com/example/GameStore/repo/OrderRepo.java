package com.example.GameStore.repo;

import com.example.GameStore.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepo extends CrudRepository<Order, Long> {

}
