package com.bootcamp.mvc01.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokoDto {
    private Integer id;
    private String  kodeToko;
    private String  namaOpt;
    private String  alamat;
    private Integer stockEnvi;
    private Integer stockNippon;
    private Integer stockDulux;
    private Integer targetValue;
}
