package com.example.hotelreservationapplication.controller;

import com.example.hotelreservationapplication.entity.Customer;
import com.example.hotelreservationapplication.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;
    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
    }
    @Operation(summary = "Create new Customer",description = "Creates a New hotel Customer")
    @ApiResponses(
            {@ApiResponse(responseCode = "200",description = "Customer Create Successfully"),@ApiResponse(responseCode = "400",description = "Invalid Customer Data")})
    @PostMapping
    public Customer save( @Valid @RequestBody Customer customer){
        return
                customerService.saveCustomer(customer);
    }

    @Operation(summary = "Get All Customer" , description = "Return All Customer Register in hotel system")
    @ApiResponses(@ApiResponse(responseCode = "200",description = "Customer retrieved successfully"))
    @GetMapping
    public List<Customer>FindAll(){

        return
                customerService.getAllCustomers();
    }
    @Operation(summary = "Get Customer By Id",description = "Return a customer Using The customer Id")
    @ApiResponses({@ApiResponse(responseCode ="200",description = "Customer Found successfully"),@ApiResponse(responseCode = "404",description = "Customer not found")})
    @GetMapping("/{id}")
    public Customer findBYId( @Parameter(description = "Customer Id",required = true,example = "2") @PathVariable Long id){
        return customerService.getCustomerById(id);
    }
    @Operation(summary = "Delete Customer",description = "Delete the customer using the customer Id")
    @ApiResponses({@ApiResponse(responseCode = "200",description = "Customer Delete Successfully"),@ApiResponse(responseCode ="404",description = "Customer not found")})
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
                customerService.deleteCustomer(id);
    }
}
