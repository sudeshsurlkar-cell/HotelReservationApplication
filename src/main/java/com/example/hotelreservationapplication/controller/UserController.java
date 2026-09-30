package com.example.hotelreservationapplication.controller;

import com.example.hotelreservationapplication.entity.User;
import com.example.hotelreservationapplication.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }
    @Operation(summary = "create new user",description ="register new user hotel system")
    @ApiResponses({@ApiResponse(responseCode = "200",description = "user register successfully"),@ApiResponse(responseCode ="400",description ="user enter invalid data")})
    @PostMapping("/register")
    public void registerUser(@RequestBody User user){
        userService.registerUser(user);
    }


}
