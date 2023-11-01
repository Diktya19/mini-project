package com.bootcamp.springmvc.entity;

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

    @Column(name = "no_pendaftaran")
    private String noPendaftaran;

    @Column(name = "nama_lengakap")
    private String namaLengkap;

    @Column(name = "nama_panggilan")
    private String namaPanggilan;

    @Column(name = "nama_bapak")
    private String namaBapak;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "asal_sekolah")
    private String asalSekolah;

    @Column(name = "jurusan_1")
    private String jurusan1;

    @Column(name = "jurusan_2")
    private String jurusan2;

    @Column(name = "nilai_un")
    private Integer nilaiUn;

    @Column(name = "nilai_us")
    private Integer nilaiUs;

    @Column(name = "jalur_masuk")
    private String jalurMasuk;
}
