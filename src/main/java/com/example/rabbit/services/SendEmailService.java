package com.example.rabbit.services;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.example.rabbit.controllers.UserRegistrationRequest;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SendEmailService {

    @RabbitListener(queues = "q.send-email")
    public void sendEmail(UserRegistrationRequest request) {
        
        log.info("Sending email to {}", request.getEmail());
    }
}
