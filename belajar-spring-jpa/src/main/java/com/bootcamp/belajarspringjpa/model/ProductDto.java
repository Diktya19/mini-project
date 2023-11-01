package com.bootcamp.belajarspringjpa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// "DTO (Data Transfer Object)
//STEP 3
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Integer id;
    private String  name;
    private String  description;
    private Integer price;
    private Integer quantity;
}
