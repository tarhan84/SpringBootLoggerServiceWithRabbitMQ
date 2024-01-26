package com.tarhan.LoggerService;

import com.tarhan.LoggerService.RabbitMQ.LoggerMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoggerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoggerServiceApplication.class, args);
	}

}
