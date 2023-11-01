package com.bootcamp.springmvc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_handphone")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HandphoneEntity {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "hp_kode", length = 10)
    private String kode;

    @Column(name = "hp_name", length = 150)
    private String name;

    @Column(name = "hp_ram")
    private String ram;

    @Column(name = "hp_batrei")
    private String batrei;

    @Column(name = "hp_storage")
    private String storage;

    @Column(name = "hp_layar")
    private String layar;

    @Column(name = "hp_warna")
    private String warna;

    @Column(name = "hp_dimensi")
    private String dimensi;

    @Column(name = "hp_rilis")
    private Integer rilis;

    @Column(name = "hp_harga")
    private Integer harga;

    @Column(name = "hp_stock")
    private Integer stock;
}
