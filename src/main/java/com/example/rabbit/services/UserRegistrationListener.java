package com.example.rabbit.services;

//This is the basic content of the message including the payload and the headers 
//but after add the Jackson2JsonMessageConverter, we don't need this anymore.
// import org.springframework.amqp.core.Message; 

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.example.rabbit.controllers.UserRegistrationRequest;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserRegistrationListener {

    private final RabbitTemplate rabbitTemplate;

    public UserRegistrationListener(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @RabbitListener(queues = {"q.user-registration"})
    public void onUserRegistration(UserRegistrationRequest event) {
        log.info("User Registration Request received: {}", event );

        // This method throws an exception to simulate a failure
        //executeRegistration(event);
        this.rabbitTemplate.convertAndSend("x.post-registration","", event);

    }

    private void executeRegistration(UserRegistrationRequest event) {
        log.info("Executing User Registration Event: {}", event);
    
        throw new RuntimeException("Registration Failed");
    
    }
}
