package com.sales.model;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@Document(collection = "logs")
public class LogDocument {
    @Id
    private String id;
    private String message;
    private String level;
    private Instant timestamp;
}
