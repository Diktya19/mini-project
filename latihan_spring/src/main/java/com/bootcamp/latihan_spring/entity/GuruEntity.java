package com.bootcamp.latihan_spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_guru")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuruEntity {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "guru_nama")
    private String  nama;

    @Column(name = "guru_ttl")
    private String  ttl;

    @Column(name = "guru_jk")
    private String  jk;

    @Column(name = "guru_agama")
    private String  agama;

    @Column(name = "guru_alamat")
    private String  alamat;

    @Column(name = "guru_sekolah")
    private String  sekolah;

    @Column(name = "guru_mapel")
    private String  mapel;

    @Column(name = "guru_waktu")
    private Integer waktu;
}
