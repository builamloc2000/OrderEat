package com.example.orderEat.application.controller;

import com.example.orderEat.application.service.RestaurantService;
import com.example.orderEat.domain.entities.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    //Call api get all restaurant in order to user select
    @GetMapping("/getAll")
    public List<Restaurant> findRestaurantList() {
        return restaurantService.fetchRestaurantList();
    }

    //Call api user select 1 restaurant
    @GetMapping("/getRestaurant/{id}")
    public Optional<Restaurant> finRestaurant(@PathVariable Integer id){
        return restaurantService.findRestaurant(id);
    }
}
