package org.example.controller;

import jakarta.validation.Valid;
import org.example.dto.PaymentRequest;
import org.example.dto.PaymentResponse;
import org.example.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    // Constructor-based dependency injection
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<PaymentResponse> createPayment(@Valid @RequestBody PaymentRequest paymentRequest) {
        PaymentResponse response = paymentService.processPayment(paymentRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
