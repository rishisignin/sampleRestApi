package org.example.controller;

import org.example.dto.PaymentRequest;
import org.example.dto.PaymentResponse;
import org.example.service.PaymentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

class PaymentControllerTest {

    @InjectMocks
    private PaymentController controller;
    @Mock
    private PaymentService paymentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new PaymentController(paymentService);
    }

    @Test
    void createPaymentTest() {
        Mockito.when(paymentService.processPayment(Mockito.any())).thenReturn(new PaymentResponse());
        PaymentRequest request = new PaymentRequest();
        ResponseEntity<PaymentResponse> response = controller.createPayment(request);
        Assertions.assertNotNull(response);
    }

    @Test
    void createPaymentTest2() {
        PaymentResponse pmtResponse = new PaymentResponse();
        pmtResponse.setMessage("Your payment will reflect shortly.");

        Mockito.when(paymentService.processPayment(Mockito.any())).thenReturn(pmtResponse);
        PaymentRequest request = new PaymentRequest();
        ResponseEntity<PaymentResponse> response = controller.createPayment(request);
        Assertions.assertEquals("Your payment will reflect shortly.", response.getBody().getMessage());
    }
}
