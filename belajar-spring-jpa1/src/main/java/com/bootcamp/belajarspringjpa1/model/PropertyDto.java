package com.bootcamp.belajarspringjpa1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDto {
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
