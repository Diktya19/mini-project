package com.bootcamp.latihan_spring.entity;

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

    @Column(name = "handphone_nama")
    private String nama;

    @Column(name = "handphone_merk")
    private String merk;

    @Column(name = "handphone_ram")
    private Integer ram;

    @Column(name = "handphone_layar")
    private String layar;

    @Column(name = "handphone_kameraDepan")
    private String kameraDepan;

    @Column(name = "handphone_kameraBelakang")
    private String kameraBelakang;

    @Column(name = "handphone_warna")
    private String warna;

    @Column(name = "handphone_penyimpanan")
    private String penyimpanan;

    @Column(name = "handphone_bateri")
    private String bateri;

    @Column(name = "handphone_dimensi")
    private String dimensi;

    @Column(name = "handphone_tahunRilis")
    private Integer tahunRilis;

    @Column(name = "handphone_os")
    private String os;
}
