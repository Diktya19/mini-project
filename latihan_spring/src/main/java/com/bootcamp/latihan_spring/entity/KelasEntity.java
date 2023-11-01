package com.bootcamp.latihan_spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_kelas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KelasEntity {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "kelas_namaKelas")
    private String namaKelas;

    @Column(name = "kelas_waliKelas")
    private String waliKelas;

    @Column(name = "kelas_jurusan")
    private String jurusan;

    @Column(name = "kelas_ketuaMurid")
    private String ketuaMurid;

    @Column(name = "kelas_jumlahMurid")
    private Integer jumlahMurid;

    @Column(name = "kelas_pria")
    private Integer pria;

    @Column(name = "kelas_perempuan")
    private Integer permpuan;

    @Column(name = "kelas_meja")
    private Integer meja;

    @Column(name = "kelas_kursi")
    private Integer kursi;
}
