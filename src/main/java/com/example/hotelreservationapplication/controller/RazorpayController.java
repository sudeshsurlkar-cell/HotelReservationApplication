package com.example.hotelreservationapplication.controller;

import com.example.hotelreservationapplication.DTO.RazorpayOrderResponse;
import com.example.hotelreservationapplication.DTO.RazorpayRequest;
import com.example.hotelreservationapplication.service.RazorpayOrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/razorpay")
public class RazorpayController {
    private final RazorpayOrderService razorpayOrderService;
    public RazorpayController(RazorpayOrderService razorpayOrderService){
        this.razorpayOrderService=razorpayOrderService;
    }
    @Operation(summary = "new razorPay",description ="create new razorPay request")
    @ApiResponses({@ApiResponse(responseCode = "200",description = "request Accept successfully")})
    @PostMapping("/order")
    public RazorpayOrderResponse
    createOrder(@RequestBody RazorpayRequest razorpayRequest){
        return razorpayOrderService.createOrder(razorpayRequest);
    }
}
