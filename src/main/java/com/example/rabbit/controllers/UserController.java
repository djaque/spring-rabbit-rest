package com.example.rabbit.controllers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final RabbitTemplate rabbitTemplate;

    public UserController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/user")
    public ResponseEntity<UserRegistrationResponse> createUser(@RequestBody UserRegistrationRequest userRegistrationRequest) {    
        rabbitTemplate.convertAndSend("q.user-registration", userRegistrationRequest );
        return ResponseEntity.ok(new UserRegistrationResponse("Message sent to the RabbitMQ Successfully"));
    }
    
}
