package com.example.orderEat.application.service;

import com.example.orderEat.domain.entities.Food;

import java.util.List;
import java.util.Optional;

public interface FoodService {
    Food saveFood(Food food);
    Food updateFood(Food food, Integer foodId);
    void deleteFood(Integer foodId);
    List<Food> fetchFoodList();
    Optional<Food> findFoodById(Integer id);
}
