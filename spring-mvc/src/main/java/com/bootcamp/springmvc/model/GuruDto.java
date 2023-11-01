package com.bootcamp.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuruDto {
    private Integer id;
    private String  nama;
    private String  ttl;
    private String  jk;
    private String  agama;
    private Integer tb;
    private Integer bb;
    private String  bangsa;
    private String  alamat;
    private String  noHp;
    private String  status;
    private String  eMail;
    private String  pendidikan;
    private String  skill;
    private String  expOrganisasi;
    private String  expKerja;
}
