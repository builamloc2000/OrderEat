package com.example.orderEat.application.controller;

import com.example.orderEat.application.service.FoodService;
import com.example.orderEat.domain.entities.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/food")
public class FoodController {
    @Autowired
    private FoodService foodService;

    @GetMapping("/getAll")
    public List<Food> fetchAllFood(){
        return foodService.fetchFoodList();

    }
    //get one food
    @GetMapping("/getFood/{id}")
    public Optional<Food> findFoodById(@PathVariable Integer id){
        return foodService.findFoodById(id);
    }
}
