package com.example.orderEat.infrastructure.configurations;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Value("${rabbitmq.queue.name}")
    private String queue;
    @Value("${rabbitmq.exchange.name}")
    private String exchange;
    @Value("${rabbitmq.routing.key}")
    private String routingKey;
    @Value("${rabbitmq.queue.json.name}")
    private String jsonQueue;
    @Value("${rabbitmq.routing.json.key}")
    private String routingJsonKey;

    @Value("${rabbitmq.queue.user.restaurant}")
    private String  queue_user_restaurant;
    @Value("${rabbitmq.exchange.user.restaurant}")
    private String  exchange_user_restaurant;
    @Value("${rabbitmq.routing.user.restaurant.key}")
    private String  routing_user_restaurant_key;

    @Value("${rabbitmq.queue.restaurant.shipper}")
    private String  queue_restaurant_shipper;
    @Value("${rabbitmq.exchange.restaurant.shipper}")
    private String  exchange_restaurant_shipper;
    @Value("${rabbitmq.routing.restaurant.shipper.key}")
    private String  routing_restaurant_shipper_key;


    @Value("${rabbitmq.queue.shipper.user}")
    private String  queue_shipper_user;
    @Value("${rabbitmq.exchange.shipper.user}")
    private String  exchange_shipper_user;
    @Value("${rabbitmq.routing.shipper.user.key}")
    private String  routing_shipper_user_key;

//    rabbitmq.queue.user.restaurant=user_restautant
//    rabbitmq.exchange.user.restaurant=user_restautant_exchange
//    rabbitmq.routing.user.restaurant.key=user_restautant_routing_key
//
//    rabbitmq.queue.restaurant.shipper=restaurant_shipper
//    rabbitmq.exchange.restaurant.shipper=restaurant_shipper_exchange
//    rabbitmq.routing.restaurant.shipper.key=user_restautant_routing_key

//    rabbitmq.queue.shipper.user=shipper_user
//    rabbitmq.exchange.shipper.user=shipper_user_exchange
//    rabbitmq.routing.shipper.user.key=shipper_user_routing_key


    @Bean
    public Queue shipper_user(){
        return new Queue(queue_shipper_user);
    }

    @Bean
    public TopicExchange exchange_shipper_user(){
        return new TopicExchange(exchange_shipper_user);
    }

    @Bean
    public Binding shipper_user_binding(){
        return BindingBuilder
                .bind(shipper_user())
                .to(exchange_shipper_user())
                .with(routing_shipper_user_key);
    }
    @Bean
    public Queue user_restaurant(){
        return new Queue(queue_user_restaurant);
    }

    @Bean
    public TopicExchange exchange_user_restaurant(){
        return new TopicExchange(exchange_user_restaurant);
    }

    @Bean
    public Binding user_restaurant_binding(){
        return BindingBuilder
                .bind(user_restaurant())
                .to(exchange_user_restaurant())
                .with(routing_user_restaurant_key);
    }

    @Bean
    public Queue restaurant_shipper(){
        return new Queue(queue_restaurant_shipper);
    }

    @Bean
    public TopicExchange exchange_restaurant_shipper(){
        return new TopicExchange(exchange_restaurant_shipper);
    }

    @Bean
    public Binding restaurant_shipper_binding(){
        return BindingBuilder
                .bind(restaurant_shipper())
                .to(exchange_restaurant_shipper())
                .with(routing_restaurant_shipper_key);
    }




    @Bean
    public Queue queue(){
        return new Queue(queue);
    }

    @Bean
    public Queue jsonQueue(){
        return new Queue(jsonQueue);
    }
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(exchange);
    }
    //binding queue and exchange using routing key
    @Bean
    public Binding binding(){
        return BindingBuilder
                .bind(queue())
                .to(exchange())
                .with(routingKey);
    }

    //bind json queue and exchange with routing key
    @Bean
    public Binding jsonBinding(){
        return BindingBuilder
                .bind(jsonQueue())
                .to(exchange())
                .with(routingJsonKey);
    }
    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}
