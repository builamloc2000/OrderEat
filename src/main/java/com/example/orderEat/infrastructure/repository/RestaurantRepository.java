package com.example.orderEat.infrastructure.repository;

import com.example.orderEat.domain.entities.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {
}
