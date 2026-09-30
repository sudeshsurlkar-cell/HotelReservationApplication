package com.example.hotelreservationapplication.service;
import com.example.hotelreservationapplication.entity.Payment;
import com.example.hotelreservationapplication.entity.Room;
import com.example.hotelreservationapplication.entity.RoomStatus;
import com.example.hotelreservationapplication.exception.ResourceNotFoundException;
import com.example.hotelreservationapplication.repository.PaymentRepository;
import com.example.hotelreservationapplication.repository.RoomRepository;
import com.example.hotelreservationapplication.entity.RoomStatus;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class RoomServiceImpl implements RoomService{
    protected RoomRepository roomRepository;
    public RoomServiceImpl(RoomRepository roomRepository){
        this.roomRepository=roomRepository;
    }
    @Override
    public Room SaveRoom(Room room){
        return roomRepository.save(room);
    }
    @Override
    public List<Room>GetAllRooms(){
            return roomRepository.findAll();
}
@Override
public List<Room>getRoomByStatus(RoomStatus status){
        return roomRepository.findByStatus(status);
}
@Override
public Room GetRoomById(Long id){
        return roomRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Room not found with id:"+id));
}

@Override
    public void DeleteRoomById(Long id){
        roomRepository.deleteById(id);
}
}