package com.example.orderEat.application.controller;

import com.example.orderEat.application.service.MenuService;

import com.example.orderEat.domain.entities.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    //if we have use case see all food to order
    //now we only have use case (user select restaurant then order menu on it)
    @GetMapping("/getAll")
    public List<Menu> findMenuList() {
        return menuService.fetchMenuList();
    }

    //get menu (all food exist in 1 restaurant) of 1 restaurant
    @GetMapping("/getMenu/{id}")
    public List<Menu> findRestaurantById(@PathVariable Integer id){
        return menuService.findRestaurantById(id);
    }


}
