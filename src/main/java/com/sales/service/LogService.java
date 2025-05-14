package com.sales.service;

import com.sales.model.LogDocument;
import com.sales.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class LogService {
    private final LogRepository logRepository;

    public void saveLog(String message, String level) {
        LogDocument log = new LogDocument();
        log.setMessage(message);
        log.setLevel(level);
        log.setTimestamp(Instant.now());
        logRepository.save(log);
    }
}
