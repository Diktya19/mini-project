package com.bootcamp.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SiswaDto {
    private Integer id;
    private String  noPendaftaran;
    private String  namaLengkap;
    private String  namaPanggilan;
    private String  namaBapak;
    private String  alamat;
    private String  asalSekolah;
    private String  jurusan1;
    private String  jurusan2;
    private Integer nilaiUn;
    private Integer nilaiUs;
    private String jalurMasuk;
}
