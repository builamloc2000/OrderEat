package com.example.orderEat.application.service.serviceImpl;

import com.example.orderEat.application.service.RestaurantService;
import com.example.orderEat.domain.entities.Restaurant;
import com.example.orderEat.infrastructure.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Override
    public List<Restaurant> fetchRestaurantList() {
        return (List<Restaurant>) restaurantRepository.findAll();
    }

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant, Integer resId) {
        return null;
    }

    @Override
    public void deleteRestaurantById(Integer resId) {
        restaurantRepository.deleteById(resId);
    }
}
