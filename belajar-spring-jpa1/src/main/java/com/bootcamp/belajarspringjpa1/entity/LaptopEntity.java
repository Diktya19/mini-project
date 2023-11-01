package com.bootcamp.belajarspringjpa1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_laptop")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LaptopEntity {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "laptop_merk")
    private String merk;

    @Column(name = "laptop_tipe")
    private String tipe;

    @Column(name = "laptop_touchbar")
    private String touchbar;

    @Column(name = "laptop_warna")
    private String warna;

    @Column(name = "laptop_layar")
    private String layar;

    @Column(name = "laptop_prosesor")
    private String prosesor;

    @Column(name = "laptop_penyimpanan")
    private String penyimpanan;

    @Column(name = "laptop_pengisian")
    private String pengisian;

    @Column(name = "laptop_kamera")
    private String kamera;

    @Column(name = "laptop_batrei")
    private String batrei;

    @Column(name = "laptop_sistem")
    private String sistem;

    @Column(name = "laptop_harga")
    private Integer harga;

    @Column(name = "laptop_stok")
    private Integer stok;
}
