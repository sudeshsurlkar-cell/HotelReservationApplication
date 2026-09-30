package com.example.hotelreservationapplication.controller;

import com.example.hotelreservationapplication.entity.Reservation;
import com.example.hotelreservationapplication.service.ReservationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
private final ReservationService reservationService;
public ReservationController(ReservationService reservationService){
this.reservationService=reservationService;
}
@PostMapping
@Operation(summary = "create A reservation",description = "Crete a new reservation in hotel ")
@ApiResponses({@ApiResponse(responseCode = "200",description = "reservation Complete Successfully"),@ApiResponse(responseCode ="400",description = "invalid reservation data")})
    public Reservation save( @Valid @RequestBody Reservation reservation){
    return reservationService.saveReservation(reservation);
}
@Operation(summary = "get reservation",description = "Grt All reservation hotel")
@ApiResponses({@ApiResponse(responseCode = "200",description ="Return all reservation in hotel")})
@GetMapping
    public List<Reservation> findAll(){
    return reservationService.getAllReservations();
}

@Operation(summary = "get reservation",description = "get reservation use the id")
@ApiResponses({@ApiResponse(responseCode = "200",description = "Reservation get the id successfully"),@ApiResponse(responseCode = "404",description = "Reservation not found by id ")})

@GetMapping("/{id}")
    public Reservation findById( @Parameter(description = "Reservation Id",required = true,example = "2") @PathVariable Long id){
    return reservationService.getReservationById(id);
}
@Operation(summary = "delete reservation",description = "Delete Reservation By Id")
@ApiResponses({@ApiResponse(responseCode = "200",description = "delete reservation successfully"),@ApiResponse(responseCode = "404",description = "reservation not found ")})
@DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
    reservationService.deleteReservationById(id);
}
}
