package com.bootcamp.latihan_spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoffeeDto {
    private Integer id;
    private String  merk;
    private String  jenisKopi;
    private String  asalDaerah;
    private String  produksi;
    private String  berat;
    private Integer harga;
    private Integer jumlah;
    private String  kadaluarsa;
}
