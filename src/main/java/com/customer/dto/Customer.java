package com.customer.dto;




import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class Customer {

    private Integer id;
    private String name;
    private String phone;
    private String eMail;

}
