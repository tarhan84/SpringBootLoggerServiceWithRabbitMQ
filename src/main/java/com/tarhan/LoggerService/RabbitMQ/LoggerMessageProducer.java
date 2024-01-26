package com.tarhan.LoggerService.RabbitMQ;

import com.tarhan.LoggerService.Dto.LoggerDto;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class LoggerMessageProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(LoggerDto message) {
        rabbitTemplate.convertAndSend("LoggerQueue", message);
    }
}
