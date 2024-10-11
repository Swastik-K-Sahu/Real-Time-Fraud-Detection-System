package com.example.fraud.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transactions")
public class Transaction {
    @Id
    private String id;
    private String accountId;
    private double amount;
    private String status;

    // Getters and Setters
}