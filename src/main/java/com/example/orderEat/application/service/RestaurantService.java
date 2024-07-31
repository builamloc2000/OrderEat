package com.example.orderEat.application.service;

import com.example.orderEat.domain.entities.Restaurant;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> fetchRestaurantList();
    Restaurant saveRestaurant(Restaurant restaurant);
    Restaurant updateRestaurant(Restaurant restaurant, Integer resId);
    void deleteRestaurantById(Integer resId);
}
