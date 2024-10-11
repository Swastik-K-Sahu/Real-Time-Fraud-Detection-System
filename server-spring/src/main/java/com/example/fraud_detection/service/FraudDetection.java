package com.example.fraud.service;

import com.example.fraud.model.Transaction;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class FraudDetectionService {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchTemplate;

    @Autowired
    private MongoTemplate mongoTemplate;

    public void detectFraud(Transaction transaction) {
        boolean isFraudulent = checkFraudInElasticsearch(transaction);
        transaction.setStatus(isFraudulent ? "FRAUD" : "SAFE");
        mongoTemplate.save(transaction);
    }

    private boolean checkFraudInElasticsearch(Transaction transaction) {
        // Example: Detect large transactions as fraud
        return transaction.getAmount() > 10000;
    }
}
