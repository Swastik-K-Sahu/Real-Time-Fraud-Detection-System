package com.example.fraud.kafka;

import com.example.fraud.model.Transaction;
import com.example.fraud.service.FraudDetectionService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private final FraudDetectionService fraudDetectionService;

    public KafkaConsumerService(FraudDetectionService fraudDetectionService) {
        this.fraudDetectionService = fraudDetectionService;
    }

    @KafkaListener(topics = "transactions", groupId = "fraud_detection_group")
    public void listen(Transaction transaction) {
        fraudDetectionService.detectFraud(transaction);
    }
}
