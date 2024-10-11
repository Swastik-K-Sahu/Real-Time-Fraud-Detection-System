package com.example.fraud.controller;

import com.example.fraud.model.Transaction;
import com.example.fraud.service.FraudDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private FraudDetectionService fraudDetectionService;

    @PostMapping("/detect")
    public Transaction detectFraud(@RequestBody Transaction transaction) {
        fraudDetectionService.detectFraud(transaction);
        return transaction;
    }
}
