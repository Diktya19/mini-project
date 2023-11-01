package com.bootcamp.latihan_spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_gudang")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GudangEntity {
    @Id
    @Column(name = "line")
    private Integer line;

    @Column(name = "gudang_rak")
    private Integer rak;

    @Column(name = "gudang_namaspv")
    private String  namaSpv;

    @Column(name = "gudang_namabarang")
    private String  namaBarang;

    @Column(name = "gudang_jumlahbarang")
    private Integer jumlahBarang;

    @Column(name = "gudang_namaceking")
    private String  namaCeking;

    @Column(name = "gudang_waktucek")
    private String waktuCek;

    @Column(name = "gudang_shift")
    private Integer shift;

    @Column(name = "gudang_produksi")
    private String  produksi;
}
