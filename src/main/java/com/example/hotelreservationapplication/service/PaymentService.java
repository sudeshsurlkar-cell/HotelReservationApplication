package com.example.hotelreservationapplication.service;

import com.example.hotelreservationapplication.entity.Payment;

import java.util.List;

public interface PaymentService {
    Payment savePayment(Payment payment);
    List<Payment>getAllPayments();
    Payment getPaymentById(Long id);
    Payment processPayment(Long id);
    void deletePaymentById(Long id);

}
