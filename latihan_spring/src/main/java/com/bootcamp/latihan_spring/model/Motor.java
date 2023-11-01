package com.bootcamp.latihan_spring.model;

import lombok.Data;

@Data
public class Motor {
    private String nama;
    private String tipemesin;
    private String cc;
    private String transmisi;
    private String kompresi;
    private String torsi;
    private String starter;
    private String kopling;
    private String pendinginmesin;
    private int harga;
    private int stok;
}
