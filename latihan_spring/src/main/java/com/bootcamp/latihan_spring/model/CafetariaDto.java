package com.bootcamp.latihan_spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CafetariaDto {
    private Integer id;
    private String  name;
    private String  description;
    private Integer price;
    private Integer quantity;
}
