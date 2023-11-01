package com.bootcamp.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SekolahDto {
    private Integer id;
    private String  kode;
    private String  nama;
    private String  alamat;
    private String  akreditasi;
    private String  jurusan;
    private String  organisasi;
    private Integer jmlGuru;
    private Integer jmlOptTu;
    private Integer jmlOptSatpam;
    private Integer jmlMuridX;
    private Integer jmlMuridXI;
    private Integer jmlMuridXII;
    private Integer totalMurid;
    private Integer totalBangunan;
}
