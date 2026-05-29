package org.example.service;

import org.example.dto.PaymentRequest;
import org.example.dto.PaymentResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PaymentService {

    public PaymentResponse processPayment(PaymentRequest request) {
        // Dummy processing logic
        return PaymentResponse.builder()
                .transactionId(UUID.randomUUID().toString())
                .status("SUCCESS")
                .amount(request.getAmount())
                .currency(request.getCurrency())
                .timestamp(LocalDateTime.now())
                .build();
    }
}
