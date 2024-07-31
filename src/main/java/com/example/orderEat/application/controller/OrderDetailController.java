package com.example.orderEat.application.controller;




import com.example.orderEat.application.service.OrderDetailService;
import com.example.orderEat.domain.entities.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/orderDetail")
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping("/order")
    public List<OrderDetail> findOrderDetailServiceList() {
        return orderDetailService.fetchOrderDetailList();
    }

    @PostMapping("/order")
    public OrderDetail saveOrderDetail(@RequestBody OrderDetail orderDetail){
        return orderDetailService.saveOrderDetail(orderDetail);
    }
    @DeleteMapping("/order/{id}")
    public String deleteOrderDetailById(@PathVariable("id") Integer id){
        orderDetailService.deleteOrderDetail(id);
        return "Deleted";
    }

}
