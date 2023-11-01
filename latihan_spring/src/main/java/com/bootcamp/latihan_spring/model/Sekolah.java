package com.bootcamp.latihan_spring.model;

import lombok.Data;

@Data
public class Sekolah {
    private int kode;
    private String nama;
    private String alamat;
    private String kepsek;
    private int masajabatan;
    private int gedung;
    private int jumlahmurid;
    private int jumlahoperator;
}
