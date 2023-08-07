package com.example.rabbit.services;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.example.rabbit.controllers.UserRegistrationRequest;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SendSmsService {
   @RabbitListener(queues = "q.send-sms")
    public void sendSms(UserRegistrationRequest request) {
        log.info("Sending sms to {} ", request.getMobileNumber());
    } 
}
