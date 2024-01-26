package com.tarhan.LoggerService.RabbitMQ;

import com.tarhan.LoggerService.Constant.MessageTypes;
import com.tarhan.LoggerService.Dto.LoggerDto;
import com.tarhan.LoggerService.Service.LoggerService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

@Service
public class LoggerMessageConsumer {

    @Autowired
    private final LoggerService loggerService;

    public LoggerMessageConsumer(LoggerService loggerService) {
        this.loggerService = loggerService;
    }

    @RabbitListener(queues = "LoggerQueue")
    public void receiveMessage(LoggerDto message) {
        if (message != null){
            if(Arrays.asList(MessageTypes.MessageTypeCreate, MessageTypes.MessageTypeFull).contains(message.MessageType)){
                loggerService.createLogRecord(message);
            }
            else if (MessageTypes.MessageTypeUpdate.equals(message.MessageType)){
                loggerService.updateLogRecord(message);
            }
        }
    }
}
