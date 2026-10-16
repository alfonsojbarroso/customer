package com.customer.model;

import com.customer.dto.CustomerDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class CustomerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", columnDefinition = "varchar(110)")
    private String name;
    @Column(name = "phone", columnDefinition = "varchar(20)")
    private String phone;

    public CustomerModel(Integer id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public CustomerModel() {
    }

    public CustomerDto toDto() {
        return new CustomerDto(
                this.id,
                this.name,
                this.phone);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
