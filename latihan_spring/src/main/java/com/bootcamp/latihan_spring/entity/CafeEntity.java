package com.bootcamp.latihan_spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_cafe")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CafeEntity {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "cafe_name")
    private String name;

    @Column(name = "cafe_description")
    private String description;

    @Column(name = "cafe_price")
    private Integer price;

    @Column(name = "cafe_quantity")
    private Integer quantity;
}