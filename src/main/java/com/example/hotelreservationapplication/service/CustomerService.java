package com.example.hotelreservationapplication.service;
import com.example.hotelreservationapplication.entity.Customer;
import java.util.List;

public interface CustomerService {
    Customer saveCustomer(Customer customer);
    List<Customer>getAllCustomers();
    Customer getCustomerById(Long id);
    void deleteCustomer(Long id);
}
