package com.sales.controller;

import com.sales.dto.LogRequest;
import com.sales.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/logs")
@RequiredArgsConstructor
public class LogController {
    private final LogService logService;

    @PostMapping
    public ResponseEntity<?> createLog(@RequestBody LogRequest request) {
        logService.saveLog(request.getMessage(), "INFO");
        return ResponseEntity.ok("Log saved to MongoDB.");
    }
}
