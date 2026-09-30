package com.example.hotelreservationapplication.service;

import com.example.hotelreservationapplication.entity.Reservation;
import com.example.hotelreservationapplication.entity.ReservationStatus;
import com.example.hotelreservationapplication.entity.Room;
import com.example.hotelreservationapplication.entity.RoomStatus;
import com.example.hotelreservationapplication.exception.ResourceNotFoundException;
import com.example.hotelreservationapplication.repository.CustomerRepository;
import com.example.hotelreservationapplication.repository.ReservationRepository;
import com.example.hotelreservationapplication.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;
    private final CustomerRepository customerRepository;
    public ReservationServiceImpl(ReservationRepository reservationRepository,RoomRepository roomRepository,CustomerRepository customerRepository){
        this.reservationRepository=reservationRepository;
        this.roomRepository=roomRepository;
        this.customerRepository=customerRepository;
    }
    @Override
    public Reservation saveReservation(Reservation reservation) {
     customerRepository.findById(reservation.getCustomerId()).orElseThrow(()->new RuntimeException("Customer  not found"));

     if(!reservation.getCheckInDate().before(reservation.getCheckOutDate())){

         throw  new RuntimeException("check out date be after check in date");
     }

     boolean overlapping=reservationRepository.existsByRoomIdAndCheckInDateAndCheckOutDateGreaterThan(reservation.getRoomId(),reservation.getCheckOutDate(),reservation.getCheckInDate());
     if(overlapping){
         throw  new RuntimeException("Room is already Booked For this Date ");
     }


        Room room = roomRepository.findById(reservation.getRoomId()).orElseThrow(() -> new RuntimeException("Room Not Found"));
        if (room.getStatus() != RoomStatus.AVAILABLE)

        {
            throw new RuntimeException("Room Is Not Available");
        }
        reservation.setStatus(ReservationStatus.PENDING);


        return reservationRepository.save(reservation);

    }


    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
    @Override
    public Reservation getReservationById(Long id){
        return reservationRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Reservation not found With Id:"+id));
    }
    @Override
    public void deleteReservationById(Long id){
        reservationRepository.deleteById(id);
    }


}

