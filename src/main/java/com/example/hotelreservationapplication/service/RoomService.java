package com.example.hotelreservationapplication.service;
import com.example.hotelreservationapplication.entity.Payment;
import com.example.hotelreservationapplication.entity.Room;
import com.example.hotelreservationapplication.entity.RoomStatus;

import java.util.List;
public interface RoomService {
    Room SaveRoom(Room room);
    List<Room>GetAllRooms();
    Room GetRoomById(Long id);
    void DeleteRoomById(Long id);
    List<Room>getRoomByStatus(RoomStatus status);
}
