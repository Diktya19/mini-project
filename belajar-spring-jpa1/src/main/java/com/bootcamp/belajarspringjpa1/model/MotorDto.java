package com.bootcamp.belajarspringjpa1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MotorDto {
    private Integer id;
    private String  nama;
    private String  tipeMesin;
    private String  cc;
    private String  transmisi;
    private String  kompresi;
    private String  bahanBakar;
    private String  torsi;
    private String  starter;
    private String  kopling;
    private String  pendinginMesin;
    private Integer harga;
    private Integer stok;
}
