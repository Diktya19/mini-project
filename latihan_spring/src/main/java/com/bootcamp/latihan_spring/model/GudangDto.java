package com.bootcamp.latihan_spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GudangDto {
    private Integer line;
    private Integer rak;
    private String  namaSpv;
    private String  namaBarang;
    private Integer jumlahBarang;
    private String  namaCeking;
    private String waktuCek;
    private Integer shift;
    private String  produksi;
}
