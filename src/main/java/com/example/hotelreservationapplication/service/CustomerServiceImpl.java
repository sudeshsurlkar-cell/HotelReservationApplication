package com.example.hotelreservationapplication.service;
import com.example.hotelreservationapplication.entity.Customer;
import com.example.hotelreservationapplication.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import com.example.hotelreservationapplication.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }


    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer not Found with id:"+id));
    }

    @Override
    public void deleteCustomer(Long id) {
         customerRepository.deleteById(id);
    }
}
