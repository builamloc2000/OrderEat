package com.example.orderEat.infrastructure.repository;

import com.example.orderEat.domain.entities.OrderDetail;
import jakarta.persistence.Id;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends CrudRepository<OrderDetail, Integer> {
}
