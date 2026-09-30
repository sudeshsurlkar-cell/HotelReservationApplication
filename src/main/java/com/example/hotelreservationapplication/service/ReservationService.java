package com.example.hotelreservationapplication.service;
import com.example.hotelreservationapplication.entity.Reservation;
import java.util.List;
public interface ReservationService {
    Reservation saveReservation(Reservation reservation);
    List<Reservation>getAllReservations();
    Reservation getReservationById(Long id);
    void deleteReservationById(Long id);

}
