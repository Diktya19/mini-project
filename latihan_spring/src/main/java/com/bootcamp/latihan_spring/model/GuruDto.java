package com.bootcamp.latihan_spring.model;

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
    private String  alamat;
    private String  sekolah;
    private String  mapel;
    private Integer waktu;
}
