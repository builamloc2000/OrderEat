package com.example.orderEat.application.service.serviceImpl;

import com.example.orderEat.application.service.FoodService;
import com.example.orderEat.domain.entities.Food;
import com.example.orderEat.infrastructure.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    private FoodRepository foodRepository;

    @Override
    public Food saveFood(Food food) {
        return foodRepository.save(food);
    }

    @Override
    public Food updateFood(Food food, Integer foodId) {
        return null;
    }

    @Override
    public List<Food> fetchFoodList() {
        return (List<Food>) foodRepository.findAll();
    }

    @Override
    public void deleteFood(Integer foodId) {
        foodRepository.deleteById(foodId);
    }
}
