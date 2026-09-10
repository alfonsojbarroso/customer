package com.customer.service;

import org.springframework.stereotype.Service;

import com.customer.dto.Customer;

@Service
public class CustomerService {

    public Customer getCustomer() {
        return Customer.builder()
                .id(1)
                .name("GORGONIO")
                .phone("1234567890")
                .eMail("gorgonio@buzon.com")
                .build();
    }

}
