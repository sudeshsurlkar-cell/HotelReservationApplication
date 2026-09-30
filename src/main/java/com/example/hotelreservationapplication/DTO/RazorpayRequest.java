package com.example.hotelreservationapplication.DTO;

public class RazorpayRequest {
    private Long reservationId;
    private double amount;

    public RazorpayRequest(){

    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
