package com.example.rabbit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * This app is a simple example of how to use RabbitMQ with Spring Boot.
 * using this web as guide: https://medium.com/javarevisited/getting-started-with-rabbitmq-in-spring-boot-6323b9179247
 * result in a simple app that send messages when a user is created.
 * this messages are listened by UserRegistrationListener
 * and then reenqueue to an exchange that send the message to two queues
 */

@SpringBootApplication
public class RabbitApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitApplication.class, args);
	}

}
