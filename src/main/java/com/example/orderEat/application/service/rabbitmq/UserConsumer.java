package com.example.orderEat.application.service.rabbitmq;

import com.example.orderEat.application.service.OrderService;
import com.example.orderEat.domain.entities.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserConsumer.class);
    @RabbitListener(queues = {"${rabbitmq.queue.shipper.user}"})
    public void consumeJsonMessage(Order order){
        LOGGER.info(String.format("Received JSON message %s", order.toString()));
        order.setStatusId(order.getStatusId()+1);
        orderService.saveOrder(order);
    }
    @Autowired
    private OrderService orderService;
}
