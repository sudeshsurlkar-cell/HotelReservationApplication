package com.example.hotelreservationapplication.controller;

import com.example.hotelreservationapplication.entity.Payment;
import com.example.hotelreservationapplication.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.System.out;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService paymentService;
    public PaymentController(PaymentService paymentService){
        this.paymentService=paymentService;
    }
    @Operation(summary ="new payment",description = "payment Fo a reservation")
    @ApiResponses({@ApiResponse(responseCode = "200",description ="create a new payment" ),@ApiResponse(responseCode = "400",description = "invalid payment Details")})
    @PostMapping
    public Payment savePayment(@Valid @RequestBody Payment payment){
        return paymentService.savePayment(payment);
    }
    @Operation(summary = "get all payments ",description = "get all payment for hotel")
    @ApiResponses({@ApiResponse(responseCode = "200",description = "Get all successful payment")})
    @GetMapping
    public List<Payment> finAllPayments(){
        return paymentService.getAllPayments();
    }
    @Operation(summary = "get payment",description = "get all Payments by payment Id")
    @ApiResponses({@ApiResponse(responseCode = "200",description = "payment successfully return by id"),@ApiResponse(responseCode ="404",description = "Payment Details not found by id")})
    @GetMapping("/{id}")
    public Payment findPaymentById( @Parameter(description = "payment Id",required = true,example = "3") @PathVariable Long id){
        return paymentService.getPaymentById(id);
    }


    @PutMapping("/process/{id}")
    public Payment processPayment(@PathVariable Long id){
        return paymentService.processPayment(id);
    }
   @Operation(summary = "delete payment",description = "delete payment by id")
   @ApiResponses({@ApiResponse(responseCode = "200",description = "payment delete by successfully by id"),@ApiResponse(responseCode = "404",description = "Payment Details not found")})
    @DeleteMapping("/{id}")
    public void deletePaymentById(@PathVariable Long id){
        paymentService.deletePaymentById(id);
    }
}
