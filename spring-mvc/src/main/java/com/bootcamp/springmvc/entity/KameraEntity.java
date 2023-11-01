package com.bootcamp.springmvc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_kamera")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KameraEntity {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "kamera_kode")
    private String kode;

    @Column(name = "kamera_name")
    private String name;

    @Column(name = "kamera_merk")
    private String merk;

    @Column(name = "kamera_tipe")
    private String tipe;

    @Column(name = "kamera_sensor")
    private String sensor;

    @Column(name = "kamera_harga")
    private Integer harga;

    @Column(name = "kamera_fitur")
    private String fitur;

    @Column(name = "kamera_lensa")
    private String lensa;

    @Column(name = "kamera_aksesori")
    private String aksesoris;
}
