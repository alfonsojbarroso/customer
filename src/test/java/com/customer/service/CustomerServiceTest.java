package com.customer.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.customer.dto.CustomerDto;
import com.customer.model.CustomerModel;
import com.customer.repository.CustomerRepository;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;
    @InjectMocks
    private CustomerService customerService;

    @Test
    @DisplayName("Debe devolver un listado de customers")
    public void findAllTest() {
        // Simulando los datos presentes en la base de datos
        List<CustomerModel> models = List.of(
                new CustomerModel(1, "John Doe", "+51 123 11 22 33"),
                new CustomerModel(2, "Espergencia Johanson", "+51 123 11 22 34"));
        when(customerRepository.findAll()).thenReturn(models);
        List<CustomerDto> dtos = customerService.findAll();
        assertThat(dtos).hasSize(2);
    }

    @Test
    public void createNewCustomer() {
        CustomerDto customerDto = new CustomerDto(1, "Tarja Turunen", "+51 123 11 22 33");
        CustomerModel customer = new CustomerModel(1, "Tarja Turunen", "+51 123 11 22 33");

        when(customerRepository.save(any(CustomerModel.class))).thenReturn(customer);

        CustomerDto dto = customerService.save(customerDto);

        assertEquals(customer.toDto(), dto);

    }

}
