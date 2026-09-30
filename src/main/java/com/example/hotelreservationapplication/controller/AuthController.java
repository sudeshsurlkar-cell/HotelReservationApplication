package com.example.hotelreservationapplication.controller;

import com.example.hotelreservationapplication.DTO.LoginRequest;
import com.example.hotelreservationapplication.service.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private  final JwtService jwtService;
    public AuthController(AuthenticationManager authenticationManager ,JwtService jwtService){
        this.authenticationManager=authenticationManager;
        this.jwtService=jwtService;
    }

    @PostMapping("/login")
    public  String login(@RequestBody LoginRequest request){

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(),request.getPassword()));
        return  jwtService.generateToken(request.getUserName());
    }

}
