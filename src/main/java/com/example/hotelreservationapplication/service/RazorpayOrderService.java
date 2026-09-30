package com.example.hotelreservationapplication.service;
import com.example.hotelreservationapplication.DTO.RazorpayOrderResponse;

import com.example.hotelreservationapplication.DTO.RazorpayRequest;
public interface RazorpayOrderService {
     RazorpayOrderResponse
     createOrder(RazorpayRequest razorpayRequest);
}
