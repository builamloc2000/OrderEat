package com.example.orderEat.application.controller;

import com.example.orderEat.application.service.RestaurantService;
import com.example.orderEat.domain.entities.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;
    @GetMapping("/getAll")
    public List<Restaurant> findRestaurantList() {
        return restaurantService.fetchRestaurantList();
    }
}
