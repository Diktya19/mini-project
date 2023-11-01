package com.bootcamp.springmvc.entity;

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

    @Column(name = "nama", length = 150)
    private String  nama;

    @Column(name = "tempat_tanggal_lahir", length = 150)
    private String  ttl;

    @Column(name = "jenis_kelamin")
    private String  jk;

    @Column(name = "agama")
    private String  agama;

    @Column(name = "tinggi_badan")
    private Integer tb;

    @Column(name = "berat_badan")
    private Integer bb;

    @Column(name = "bangsa")
    private String  bangsa;

    @Column(name = "alamat")
    private String  alamat;

    @Column(name = "no handphone")
    private String  noHp;

    @Column(name = "status")
    private String  status;

    @Column(name = "e_mail")
    private String  eMail;

    @Column(name = "pendidikan")
    private String  pendidikan;

    @Column(name = "skill")
    private String  skill;

    @Column(name = "pengalaman_organisasi")
    private String  expOrganisasi;

    @Column(name = "pengalaman_kerja")
    private String  expKerja;
}
