package com.example.orderEat.application.controller;

import com.example.orderEat.application.service.rabbitmq.RabbitMQJsonProducer;
import com.example.orderEat.domain.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
//demo rabbit json msg
public class MessageJsonController {
    private RabbitMQJsonProducer jsonProducer;

    public MessageJsonController(RabbitMQJsonProducer jsonProducer) {
        this.jsonProducer = jsonProducer;
    }
    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
        jsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Json message");
    }
}
