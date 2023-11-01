package com.bootcamp.springmvc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_sekolah")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SekolahEntity {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "Kode_sekolah")
    private String  kode;

    @Column(name = "nama_sekolah")
    private String  nama;

    @Column(name = "alamat_sekolah")
    private String  alamat;

    @Column(name = "akreditasi_sekolah")
    private String  akreditasi;

    @Column(name = "jurusan")
    private String  jurusan;

    @Column(name = "organisasi")
    private String  organisasi;

    @Column(name = "jumlah_guru")
    private Integer jmlGuru;

    @Column(name = "jumlah_operator_tata_usaha")
    private Integer jmlOptTu;

    @Column(name = "jumlah_operator_satpam")
    private Integer jmlOptSatpam;

    @Column(name = "jumlah_murid_X")
    private Integer jmlMuridX;

    @Column(name = "jumlah_murid_XI")
    private Integer jmlMuridXI;

    @Column(name = "jumlah_murid_XII")
    private Integer jmlMuridXII;

    @Column(name = "total_murid")
    private Integer totalMurid;

    @Column(name = "total_bangunan")
    private Integer totalBangunan;
}
