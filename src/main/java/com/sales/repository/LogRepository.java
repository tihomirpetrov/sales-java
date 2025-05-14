package com.sales.repository;

import com.sales.model.LogDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<LogDocument, String> {
}
