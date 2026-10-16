package com.customer.dto;

import com.customer.model.CustomerModel;

public record CustomerDto(
        Integer id,
        String name,
        String phone) {

    public CustomerModel toModel() {
        return new CustomerModel(null, this.name, this.phone);
    }

}
