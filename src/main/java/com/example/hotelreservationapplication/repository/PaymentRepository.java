package com.example.hotelreservationapplication.repository;

import com.example.hotelreservationapplication.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
