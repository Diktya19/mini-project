package com.bootcamp.mvc01.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_Orang")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrangEntity {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "kode")
    private String kode;

    @Column(name = "nama")
    private String nama;

    @Column(name = "nama panggilan")
    private String namaPanggilan;

    @Column(name = "nama ortu")
    private String namaOrtu;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "jenis kelamin")
    private String jk;

    @Column(name = "tinggi badan")
    private Integer tb;

    @Column(name = "berat badan")
    private Integer bb;

    @Column(name = "umur")
    private Integer umur;

    @Column(name = "status")
    private String status;
}
