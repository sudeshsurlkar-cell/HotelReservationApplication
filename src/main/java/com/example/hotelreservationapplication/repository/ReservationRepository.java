package com.example.hotelreservationapplication.repository;

import com.example.hotelreservationapplication.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;


public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    boolean
    existsByRoomIdAndCheckInDateAndCheckOutDateGreaterThan(
            Long roomId,
            Date checkOutDate,
            Date checkInDate

    );
}
