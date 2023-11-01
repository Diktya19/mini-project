package com.bootcamp.mvc01.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_siswa")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SiswaEntity {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "kode")
    private String  kode;

    @Column(name = "nama")
    private String  nama;

    @Column(name = "nama panggilan")
    private String  namaPanggilan;

    @Column(name = "nama orang tua")
    private String  namaOrtu;

    @Column(name = "alamat")
    private String  alamat;

    @Column(name = "umur")
    private Integer umur;

    @Column(name = "tinggi badan")
    private Integer tb;

    @Column(name = "berat badan")
    private Integer bb;

    @Column(name = "asal sekolah")
    private String  asalSekolah;

    @Column(name = "jalur masuk")
    private String  jalurMasuk;
}
