package com.example.orderEat.application.service.serviceImpl;

import com.example.orderEat.application.service.OrderDetailService;
import com.example.orderEat.domain.entities.OrderDetail;
import com.example.orderEat.infrastructure.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public void deleteOrderDetail(Integer orderDetailId) {
        orderDetailRepository.deleteById(orderDetailId);
    }

    @Override
    public List<OrderDetail> fetchOrderDetailList() {
        return (List<OrderDetail>) orderDetailRepository.findAll();
    }

    @Override
    public List<OrderDetail> findByOrderId(Integer id) {
        return orderDetailRepository.findByOrderId(id);
    }

    @Override
    public OrderDetail updateOrderDetail(OrderDetail orderDetail, Integer orderDetailId) {
        return null;
    }

    @Override
    public OrderDetail saveOrderDetail(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }
}
