package com.example.orderEat.application.service.rabbitmq;

import com.example.orderEat.domain.entities.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserProducer {
    @Value("${rabbitmq.exchange.user.restaurant}")
    private String  exchange_user_restaurant;
    @Value("${rabbitmq.routing.user.restaurant.key}")
    private String  routing_user_restaurant_key;
    private RabbitTemplate rabbitTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserProducer.class);

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendJsonMessage(Order order){
        LOGGER.info(String.format("Json message %s", order.toString()));
        rabbitTemplate.convertAndSend(exchange_user_restaurant, routing_user_restaurant_key, order);
    }
}
