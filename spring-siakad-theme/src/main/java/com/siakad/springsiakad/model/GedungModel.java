package com.siakad.springsiakad.model;

import com.siakad.springsiakad.entity.GedungEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GedungModel {
    private String id;
    private String code;
    private String name;
    private Integer jumlahLantai;

    public GedungModel(GedungEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
