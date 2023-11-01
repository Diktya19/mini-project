package com.bootcamp.belajarspringjpa1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_property")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyEntity {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "penanggun_jawab")
    private String  penanggungJawab;

    @Column(name = "nama_property")
    private String  namaProperty;

    @Column(name = "berdiri_dari")
    private Integer berdiriDari;

    @Column(name = "deskripsi")
    private String  deskripsi;

    @Column(name = "warna")
    private String  warna;

    @Column(name = "alamat")
    private String  alamat;

    @Column(name = "terisi")
    private Integer terisi;

    @Column(name = "kosong")
    private Integer kosong;

    @Column(name = "kondisi_tempat")
    private String  kondisiTempat;

    @Column(name = "problem")
    private String  problem;
}
