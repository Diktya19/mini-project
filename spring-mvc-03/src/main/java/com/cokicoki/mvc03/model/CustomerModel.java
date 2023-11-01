package com.cokicoki.mvc03.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerModel {
    private Integer id;
    private Long accountNo;
    private String name;
    private String email;
    private String phoneNo;
    private String address;
}
