package com.example.orderEat.application.service.rabbitmq;

import com.example.orderEat.domain.entities.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ShipperProducer {
    @Value("${rabbitmq.exchange.shipper.user}")
    private String  exchange_shipper_user;
    @Value("${rabbitmq.routing.shipper.user.key}")
    private String  routing_shipper_user_key;
    private RabbitTemplate rabbitTemplate;

    public ShipperProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    private static final Logger LOGGER = LoggerFactory.getLogger(ShipperProducer.class);
    public void sendJsonMessage(Order order){
        LOGGER.info(String.format("Json message %s", order.toString()));
        rabbitTemplate.convertAndSend(exchange_shipper_user, routing_shipper_user_key, order);
    }
}
