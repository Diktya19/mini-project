package com.bootcamp.latihan_spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KelasDto {
    private Integer id;
    private String namaKelas;
    private String waliKelas;
    private String jurusan;
    private String ketuaMurid;
    private Integer jumlahMurid;
    private Integer pria;
    private Integer permpuan;
    private Integer meja;
    private Integer kursi;
}
