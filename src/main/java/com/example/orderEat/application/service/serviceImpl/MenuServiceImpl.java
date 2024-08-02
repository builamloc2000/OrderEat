package com.example.orderEat.application.service.serviceImpl;

import com.example.orderEat.application.service.MenuService;
import com.example.orderEat.domain.entities.Menu;
import com.example.orderEat.infrastructure.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuRepository menuRepository;

    @Override
    public Menu saveMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public Menu updateMenu(Menu menu, Integer menuId) {
        return null;
    }

    @Override
    public List<Menu> fetchMenuList() {
        return (List<Menu>) menuRepository.findAll();
    }

    @Override
    public void deleteMenu(Integer menuId) {
        menuRepository.deleteById(menuId);
    }

    @Override
    public List<Menu> findRestaurantById(Integer resId) {
        return menuRepository.findByRestaurantId(resId);
    }


}
