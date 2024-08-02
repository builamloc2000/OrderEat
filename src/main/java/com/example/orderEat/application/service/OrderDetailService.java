package com.example.orderEat.application.service;

import com.example.orderEat.domain.entities.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    OrderDetail saveOrderDetail(OrderDetail orderDetail);
    OrderDetail updateOrderDetail(OrderDetail orderDetail, Integer orderDetailId);
    void deleteOrderDetail(Integer orderDetailId);
    List<OrderDetail> fetchOrderDetailList();
    List<OrderDetail> findByOrderId(Integer id);
}
