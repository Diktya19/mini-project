package com.bootcamp.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LaptopDto {
    private Integer id;
    private String  kode;
    private String  name;
    private String  ram;
    private String  processor;
    private String  storage;
    private String  os;
    private String  layar;
    private String  dimensi;
    private String  warna;
    private Integer rilis;
    private Integer harga;
    private Integer stock;
}
