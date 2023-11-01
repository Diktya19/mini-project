package com.bootcamp.latihan_spring.model;

import lombok.Data;

@Data
public class HandphoneDto {
    private Integer id;
    private String  nama;
    private String  merk;
    private Integer ram;
    private String  layar;
    private String  kameraDepan;
    private String  kameraBelakang;
    private String  warna;
    private String  penyimpanan;
    private String  bateri;
    private String  dimensi;
    private Integer tahunRilis;
    private String  os;
}
