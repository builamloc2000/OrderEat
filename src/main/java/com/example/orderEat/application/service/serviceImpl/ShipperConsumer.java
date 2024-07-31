package com.example.orderEat.application.service.serviceImpl;

import com.example.orderEat.application.service.OrderService;
import com.example.orderEat.domain.entities.Order;
import com.example.orderEat.domain.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipperConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShipperConsumer.class);

    private ShipperProducer shipperProducer;

    public ShipperConsumer(ShipperProducer shipperProducer) {
        this.shipperProducer = shipperProducer;
    }
    @Autowired
    private OrderService orderService;

    @RabbitListener(queues = {"${rabbitmq.queue.restaurant.shipper}"})
    public void consumeJsonMessage(Order order){
        LOGGER.info(String.format("Received JSON message %s", order.toString()));

        order.setStatusId(order.getStatusId()+1);
        orderService.saveOrder(order);
        shipperProducer.sendJsonMessage(order);
    }
}
