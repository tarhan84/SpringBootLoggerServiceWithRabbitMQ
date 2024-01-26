package com.tarhan.LoggerService.Dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
public class LoggerDto implements Serializable {
    public String MessageType;
    public Object RequestData;
    public Object ResponseData;
    public String ServiceId;
    public Long ServiceLogId;
}
