package com.bootcamp.belajarspringjpa1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrangDto {
    private Integer id;
    private String  nama;
    private String  ttl;
    private String  agama;
    private String  jk;
    private Integer tb;
    private Integer bb;
    private Integer umur;
    private String  alamat;
    private String  namaOrtu;
    private String  noHp;
}
