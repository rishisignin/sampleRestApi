package org.example.service;

import org.example.dto.PaymentRequest;
import org.example.dto.PaymentResponse;
import org.example.entity.Payment;
import org.example.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public PaymentResponse processPayment(PaymentRequest request) {
        Payment payment = Payment.builder()
                .chargeCustomAmount(request.getChargeCustomAmount())
                .customAmount(request.getCustomAmount())
                .cardNumberLast4(lastFour(request.getCardNumber()))
                .expirationDate(request.getExpirationDate())
                .cardHolderName(request.getCardHolderName())
                .zipCode(request.getZipCode())
                .createdAt(Instant.now())
                .build();

        paymentRepository.save(payment);

        return PaymentResponse.builder()
                .message("Your payment will reflect shortly.")
                .build();
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    private String lastFour(String cardNumber) {
        if (cardNumber == null || cardNumber.length() < 4) {
            return null;
        }
        return cardNumber.substring(cardNumber.length() - 4);
    }
}
