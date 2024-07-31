package com.example.orderEat.application.service.serviceImpl;

import com.example.orderEat.application.service.OrderService;
import com.example.orderEat.domain.entities.Order;

import com.example.orderEat.domain.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class RestaurantConsumer {


    @RabbitListener(queues = {"${rabbitmq.queue.user.restaurant}"})
    public void consumeJsonMessage(Order order){
        LOGGER.info(String.format("Received JSON message %s", order.toString()));

        order.setStatusId(order.getStatusId()+1);
        orderService.saveOrder(order);
        restaurantProducer.sendJsonMessage(order);
    }
    @Autowired
    private OrderService orderService;
    private RestaurantProducer restaurantProducer;


    public RestaurantConsumer(RestaurantProducer restaurantProducer) {
        this.restaurantProducer = restaurantProducer;
    }
    private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantConsumer.class);


}
