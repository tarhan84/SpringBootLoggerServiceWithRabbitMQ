package com.tarhan.LoggerService.Service;

import com.tarhan.LoggerService.Constant.MessageTypes;
import com.tarhan.LoggerService.Dto.LoggerDto;
import com.tarhan.LoggerService.Entity.LogRecord;
import com.tarhan.LoggerService.Repository.LogRecordRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.spi.LoggerRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LoggerService {

    @Autowired
    private final LogRecordRepository logRecordRepository;

    public LoggerService(LogRecordRepository logRecordRepository) {
        this.logRecordRepository = logRecordRepository;
    }

    public void createLogRecord(LoggerDto loggerDto) {
        LogRecord newRecord = new LogRecord();
        newRecord.serviceLogId = loggerDto.ServiceLogId;
        newRecord.requestData = loggerDto.RequestData.toString();
        newRecord.responseData = loggerDto.ResponseData != null ? loggerDto.ResponseData.toString() : null;
        newRecord.serviceId = loggerDto.ServiceId;
        newRecord.isLoggingCompleted = MessageTypes.MessageTypeFull.equals(loggerDto.MessageType);
        newRecord.createDateTime = LocalDateTime.now();

        logRecordRepository.save(newRecord);
    }

    public void updateLogRecord(LoggerDto loggerDto) {
        LogRecord rec = logRecordRepository.findByServiceLogIdAndServiceId(loggerDto.ServiceLogId, loggerDto.ServiceId);
        if (rec != null) {
            rec.updateDateTime = LocalDateTime.now();
            rec.isLoggingCompleted = true;
            rec.responseData = loggerDto.ResponseData != null ? loggerDto.ResponseData.toString() : null;
            logRecordRepository.save(rec);
        }
    }
}
