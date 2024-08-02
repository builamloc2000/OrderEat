package com.example.orderEat.application.controller;

import com.example.orderEat.application.service.OrderService;
import com.example.orderEat.application.service.rabbitmq.UserProducer;
import com.example.orderEat.domain.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class OrderController {
    @Autowired
    private OrderService orderService;
    private UserProducer userProducer;



    public OrderController(UserProducer userProducer) {
        this.userProducer = userProducer;
    }
    //flow user place order with rabbitmq
    @PostMapping("/user/placeOrder")
    public ResponseEntity<String> sendJsonMessage(@RequestBody Order order){

        orderService.saveOrder(order);
        userProducer.sendJsonMessage(order);
        return ResponseEntity.ok("Json message");
    }
}
