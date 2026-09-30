package com.example.hotelreservationapplication.service;

import com.example.hotelreservationapplication.DTO.RazorpayRequest;
import org.springframework.stereotype.Service;
import com.example.hotelreservationapplication.DTO.RazorpayOrderResponse;

@Service
public class RazorpayOrderServiceImpl implements RazorpayOrderService {
    @Override
    public  RazorpayOrderResponse
    createOrder(RazorpayRequest razorpayRequest){
        return new RazorpayOrderResponse("TEMP_ORDER_ID",(long)(razorpayRequest.getAmount()*100),"INR");
    }
}