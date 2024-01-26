package com.tarhan.LoggerService.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Table(name = "LOG_RECORD", schema = "LOGGER")
@Entity
public class LogRecord implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    public long Id;

    @Column(name = "REQUEST_DATA")
    public String requestData;

    @Column(name = "RESPONSE_DATA")
    public String responseData;

    @Column(name = "SERVICE_ID")
    public String serviceId;

    @Column(name = "SERVICE_LOG_ID", nullable = false)
    public Long serviceLogId;

    @Column(name = "IS_LOGGING_COMPLETED")
    public boolean isLoggingCompleted;

    @Column(name = "CREATE_DATE_TIME", nullable = false)
    public LocalDateTime createDateTime;

    @Column(name = "UPDATE_DATE_TIME")
    public LocalDateTime updateDateTime;
}
