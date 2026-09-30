package com.example.hotelreservationapplication.controller;
import com.example.hotelreservationapplication.entity.Room;
import com.example.hotelreservationapplication.entity.RoomStatus;
import com.example.hotelreservationapplication.service.RoomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService roomService;
    public RoomController(RoomService roomService){
        this.roomService=roomService;
    }
    @Operation(summary ="Create a room",description = "Create a Room for New Customer")
    @ApiResponses({@ApiResponse(responseCode = "200",description = "Room Create a successfully"),@ApiResponse(responseCode ="400",description = "Invalid Room Data")})
    @PostMapping
    public Room save(@Valid @RequestBody Room room){
        return roomService.SaveRoom(room);
    }
    @Operation(summary ="Get All Room",description ="Return Al Room Exsits the hotel")
    @ApiResponses(@ApiResponse(responseCode = "200",description = "Collected All data To Room"))
    @GetMapping
    public List<Room>findAll(){
        return roomService.GetAllRooms();
    }
    @Operation(summary = "Get Room by id",description = "Get the room usi g the room id")
    @ApiResponses({@ApiResponse(responseCode = "200",description = "Room create Successfully"),@ApiResponse(responseCode ="404",description = "Room not Found By invalid Id")})
    @GetMapping("/{id}")
    public Room findById(@Parameter(description = "Room Id",required = true,example ="3") @PathVariable Long id){
        return roomService.GetRoomById(id);
    }
    @GetMapping("/avilable")
    public List<Room>getAvailableRooms(){
        return
                roomService.getRoomByStatus(RoomStatus.AVAILABLE);
    }
    @Operation(summary ="delete Room",description = "Delete Room using the id")
    @ApiResponses({@ApiResponse(responseCode = "200",description = "Room Deleted the successfully"),@ApiResponse(responseCode = "400",description ="Room not Found by id ")})

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        roomService.DeleteRoomById(id);
    }
}
