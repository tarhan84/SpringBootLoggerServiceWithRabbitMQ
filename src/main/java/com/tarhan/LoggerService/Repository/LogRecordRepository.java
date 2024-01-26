package com.tarhan.LoggerService.Repository;

import com.tarhan.LoggerService.Entity.LogRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRecordRepository extends JpaRepository<LogRecord, Long> {
    LogRecord findByServiceLogIdAndServiceId(Long serviceLogId, String serviceId);
}
