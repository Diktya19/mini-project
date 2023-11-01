package com.bootcamp.belajarspringjpa1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_orang")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrangEntity {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "org_nama")
    private String  nama;

    @Column(name = "org_ttl")
    private String  ttl;

    @Column(name = "org_agama")
    private String  agama;

    @Column(name = "org_jk")
    private String  jk;

    @Column(name = "org_tb")
    private Integer tb;

    @Column(name = "org_bb")
    private Integer bb;

    @Column(name = "org_umur")
    private Integer umur;

    @Column(name = "org_alamat")
    private String  alamat;

    @Column(name = "org_ortu")
    private String  namaOrtu;

    @Column(name = "org_nohp")
    private String  noHp;
}
