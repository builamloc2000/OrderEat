package com.example.orderEat.infrastructure.repository;

import com.example.orderEat.domain.entities.Menu;
import jakarta.persistence.Id;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends CrudRepository<Menu, Integer> {
    List<Menu> findByRestaurantId(Integer resId);
}
