package com.bootcamp.belajarspringjpa1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LaptopDto {
    private Integer id;
    private String merk;
    private String tipe;
    private String touchbar;
    private String warna;
    private String layar;
    private String prosesor;
    private String penyimpanan;
    private String pengisian;
    private String kamera;
    private String batrei;
    private String sistem;
    private Integer harga;
    private Integer stok;
}
