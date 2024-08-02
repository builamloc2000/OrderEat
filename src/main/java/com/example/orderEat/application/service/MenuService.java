package com.example.orderEat.application.service;

import com.example.orderEat.domain.entities.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> fetchMenuList();
    Menu saveMenu(Menu menu);
    Menu updateMenu(Menu menu, Integer menuId);
    void deleteMenu(Integer menuId);
    List<Menu> findRestaurantById(Integer resId);
}
