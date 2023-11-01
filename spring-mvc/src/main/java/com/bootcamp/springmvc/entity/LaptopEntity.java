package com.bootcamp.springmvc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_laptop")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LaptopEntity {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "laptop_kode")
    private String kode;

    @Column(name = "laptop_name")
    private String name;

    @Column(name = "laptop_ram")
    private String ram;

    @Column(name = "laptop_processor")
    private String processor;

    @Column(name = "laptop_storage")
    private String storage;

    @Column(name = "laptop_os")
    private String os;

    @Column(name = "laptop_layar")
    private String layar;

    @Column(name = "laptop_dimensi")
    private String dimensi;

    @Column(name = "laptop_warna")
    private String warna;

    @Column(name = "laptop_rilis")
    private Integer rilis;

    @Column(name = "laptop_harga")
    private Integer harga;

    @Column(name = "laptop_stock")
    private Integer stock;
}
