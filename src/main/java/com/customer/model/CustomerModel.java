package com.customer.model;

import com.customer.dto.Customer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    

    public Customer toDto() {
        return Customer.builder()
                .id(this.id)
                .name(this.name)
                .phone(this.phone)
                .build();
    }

}
