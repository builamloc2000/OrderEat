package com.example.orderEat.application.controller;

import com.example.orderEat.application.service.MenuService;

import com.example.orderEat.domain.entities.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;
    @GetMapping("/getAll")
    public List<Menu> findMenuList() {
        return menuService.fetchMenuList();
    }

}
