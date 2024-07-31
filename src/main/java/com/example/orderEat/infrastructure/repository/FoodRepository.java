package com.example.orderEat.infrastructure.repository;

import com.example.orderEat.domain.entities.Food;
import jakarta.persistence.Id;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends CrudRepository<Food, Integer> {
}
