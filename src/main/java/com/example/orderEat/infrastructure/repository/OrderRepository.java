package com.example.orderEat.infrastructure.repository;

import com.example.orderEat.domain.entities.Order;
import jakarta.persistence.Id;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
}
