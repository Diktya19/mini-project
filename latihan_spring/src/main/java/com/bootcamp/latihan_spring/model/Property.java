package com.bootcamp.latihan_spring.model;

import lombok.Data;

@Data
public class Property {
    private Integer id;
    private String  penanggungJawab;
    private String  namaProperty;
    private Integer berdiriDari;
    private String  deskripsi;
    private String  warna;
    private String  alamat;
    private Integer terisi;
    private Integer kosong;
    private String  kondisiTempat;
    private String  problem;
}
