package com.bootcamp.belajarspringjpa1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_motor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MotorEntity {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "motor_nama")
    private String nama;

    @Column(name = "motor_tipeMesin")
    private String tipeMesin;

    @Column(name = "motor_cc")
    private String cc;

    @Column(name = "motor_transmisi")
    private String transmisi;

    @Column(name = "motor_kompresi")
    private String kompresi;

    @Column(name = "motor_bahanbakar")
    private String bahanBakar;

    @Column(name = "motor_torsi")
    private String torsi;

    @Column(name = "motor_starter")
    private String starter;

    @Column(name = "motor_kopling")
    private String kopling;

    @Column(name = "motor_pendinginMesin")
    private String pendinginMesin;

    @Column(name = "motor_harga")
    private Integer harga;

    @Column(name = "motor_stok")
    private Integer stok;
}
