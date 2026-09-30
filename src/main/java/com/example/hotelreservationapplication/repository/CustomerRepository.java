package com.example.hotelreservationapplication.repository;
import com.example.hotelreservationapplication.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

    

}
