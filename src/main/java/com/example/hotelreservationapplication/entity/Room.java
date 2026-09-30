package com.example.hotelreservationapplication.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Room  {
    @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
    @Min(value=1,message = "Room Number must be greater than 0")
    private int roomNumber;
    @NotBlank(message = "Room type is required")
    private String roomType;
    @Min(value=1, message = "price must be greater than o")
    private double price;
    @Enumerated(EnumType.STRING)
    private RoomStatus status;

    public Room(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }
}
