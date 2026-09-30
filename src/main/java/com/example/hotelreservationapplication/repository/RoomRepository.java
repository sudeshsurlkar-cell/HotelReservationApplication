package com.example.hotelreservationapplication.repository;

import com.example.hotelreservationapplication.entity.RoomStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hotelreservationapplication.entity.Room;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Long> {

    List<Room>findByStatus(RoomStatus status);
}
