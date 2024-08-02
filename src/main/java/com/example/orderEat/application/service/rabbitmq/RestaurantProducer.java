package com.example.orderEat.application.service.rabbitmq;

import com.example.orderEat.domain.entities.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RestaurantProducer {
    @Value("${rabbitmq.exchange.restaurant.shipper}")
    private String  exchange_restaurant_shipper;
    @Value("${rabbitmq.routing.restaurant.shipper.key}")
    private String  routing_restaurant_shipper_key;
    private RabbitTemplate rabbitTemplate;

    public RestaurantProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantProducer.class);
    public void sendJsonMessage(Order order){
        LOGGER.info(String.format("Json message %s", order.toString()));
        rabbitTemplate.convertAndSend(exchange_restaurant_shipper, routing_restaurant_shipper_key, order);
    }
}
