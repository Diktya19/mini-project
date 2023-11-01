package com.bootcamp.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KameraDto {
    private Integer id;
    private String  kode;
    private String  name;
    private String  merk;
    private String  tipe;
    private String  sensor;
    private Integer harga;
    private String  fitur;
    private String  lensa;
    private String  aksesoris;
}
