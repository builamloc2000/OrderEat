package com.example.orderEat.application.service.serviceImpl;

import com.example.orderEat.application.service.OrderService;
import com.example.orderEat.domain.entities.Order;
import com.example.orderEat.infrastructure.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;



    @Override
    public Order updateOrder(Order order, Integer orderId) {
        Order orderDB = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        if(order.getStatusId() != 0){
            orderDB.setStatusId(order.getStatusId());
        }
        return orderRepository.save(orderDB);
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> fetchOrderList() {
        return (List<Order>) orderRepository.findAll();
    }

    @Override
    public void deleteOrderById(Integer orderId) {
        orderRepository.deleteById(orderId);
    }


}
