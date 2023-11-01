package com.bootcamp.mvc01.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrangDto {
    private Integer id;
    private String kode;
    private String nama;
    private String namaPanggilan;
    private String namaOrtu;
    private String alamat;
    private String jk;
    private Integer tb;
    private Integer bb;
    private Integer umur;
    private String status;
}
