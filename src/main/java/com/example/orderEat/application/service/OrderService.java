package com.example.orderEat.application.service;

import com.example.orderEat.domain.entities.Order;

import java.util.List;

public interface OrderService {
    Order saveOrder(Order order);
    List<Order> fetchOrderList();
    Order updateOrder(Order order, Integer orderId);
    void deleteOrderById(Integer orderId);

}
