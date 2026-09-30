package com.example.hotelreservationapplication.service;

import com.example.hotelreservationapplication.entity.*;
import com.example.hotelreservationapplication.exception.ResourceNotFoundException;
import com.example.hotelreservationapplication.repository.PaymentRepository;
import com.example.hotelreservationapplication.repository.ReservationRepository;
import com.example.hotelreservationapplication.repository.RoomRepository;
import org.springframework.stereotype.Service;
import com.example.hotelreservationapplication.service.PaymentService;

import java.util.List;


@Service
public class PaymentServiceImpl implements PaymentService{

    private final PaymentRepository paymentRepository;
    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;
    public PaymentServiceImpl(PaymentRepository paymentRepository,ReservationRepository reservationRepository,RoomRepository roomRepository){
        this.paymentRepository=paymentRepository;
        this.reservationRepository=reservationRepository;
        this. roomRepository=roomRepository;
    }

    @Override
    public Payment savePayment(Payment payment) {
      payment.setPaymentStatus(PaymentStatus.PENDING);
        return paymentRepository.save(payment);
    }
    @Override
    public Payment processPayment(Long id){
        Payment payment=paymentRepository.findById((id)).orElseThrow(()->new RuntimeException("Payment not found"));
        payment.setPaymentStatus(PaymentStatus.SUCCESS);
        Reservation reservation=reservationRepository.findById(payment.getReservationId()).orElseThrow(()->new RuntimeException("Reservation not found"));
        reservation.setStatus(ReservationStatus.BOOKED);
        Room room=roomRepository.findById(reservation.getRoomId()).orElseThrow(()->new RuntimeException("Room Not Found"));
        room.setStatus(RoomStatus.OCCUPIED);
        roomRepository.save(room);
     return payment;
    }


    @Override
    public List<Payment>getAllPayments(){
        return paymentRepository.findAll();
    }
    @Override
    public Payment getPaymentById(Long id){
        return paymentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Payment not found with id:"+id));
    }
    @Override
    public void deletePaymentById(Long id){
        paymentRepository.deleteById(id);
    }
}
