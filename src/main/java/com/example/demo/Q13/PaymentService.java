package com.example.demo.Q13;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentService {

    @Autowired
    private RestTemplate restTemplate;

    @CircuitBreaker(name = "paymentService", fallbackMethod = "fallbackPayment")
    public PaymentResponse callPaymentService() {

        return restTemplate.getForObject(
                "http://payment-service/pay",
                PaymentResponse.class
        );
    }

    public PaymentResponse fallbackPayment(Exception ex) {

        return new PaymentResponse("Payment Service Down");
    }
}