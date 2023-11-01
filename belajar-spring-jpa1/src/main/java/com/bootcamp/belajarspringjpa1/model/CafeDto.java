package com.bootcamp.belajarspringjpa1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CafeDto {
    private Integer id;
    private String name;
    private String description;
    private Integer price;
    private Integer quantity;
}
