package com.bootcamp.mvc01.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_toko")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokoEntity {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "kode toko")
    private String  kodeToko;

    @Column(name = "nama operator")
    private String  namaOpt;

    @Column(name = "alamat")
    private String  alamat;

    @Column(name = "stock envi")
    private Integer stockEnvi;

    @Column(name = "stock nippon")
    private Integer stockNippon;

    @Column(name = "stock dulux")
    private Integer stockDulux;

    @Column(name = "target value")
    private Integer targetValue;
}