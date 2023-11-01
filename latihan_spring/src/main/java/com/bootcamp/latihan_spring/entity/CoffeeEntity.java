package com.bootcamp.latihan_spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "tbl_coffee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoffeeEntity {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "coffee_merk")
    private String  merk;

    @Column(name = "coffee_jenis")
    private String  jenisKopi;

    @Column(name = "coffee_asalDaerah")
    private String  asalDaerah;

    @Column(name = "coffee_produksi")
    private String  produksi;

    @Column(name = "coffee_berat")
    private String  berat;

    @Column(name = "coffee_harga")
    private Integer harga;

    @Column(name = "coffee_jumlah")
    private Integer jumlah;

    @Column(name = "coffee_kadaluarsa")
    private String  kadaluarsa;
}
