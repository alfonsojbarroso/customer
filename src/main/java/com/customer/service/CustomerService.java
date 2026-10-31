package com.customer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.customer.dto.CustomerDto;
import com.customer.model.CustomerModel;
import com.customer.repository.CustomerRepository;

@Service
public class CustomerService {

    // Jespus Eduardo Aceves Aguirre : Agregar en el moodle

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerDto> findAll() {
        return customerRepository.findAll().stream().map(CustomerModel::toDto).toList();
    }

    public CustomerDto save(CustomerDto customer) {
        return customerRepository.save(customer.toModel()).toDto();
    }

}
