package com.customer.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.service.CustomerService;
import com.customer.dto.*;

@RestController
@RequestMapping("/api/v1")
// @CrossOrigin(origins = "http://localhost:PORT")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer")
    public ResponseEntity<?> getById() {

        List<CustomerDto> list = customerService.findAll();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/customer")
    public ResponseEntity<?> save(@RequestBody CustomerDto customer) {
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.OK);
    }

}
