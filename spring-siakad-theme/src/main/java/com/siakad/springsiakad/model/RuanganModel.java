package com.siakad.springsiakad.model;

import com.siakad.springsiakad.entity.RuanganEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RuanganModel {
    private String id;
    private String code;
    private String name;
    private String gedungId;
    private String gedungName;

    public RuanganModel(RuanganEntity entity) {
        BeanUtils.copyProperties(entity, this);

        if (entity.getGedung() != null) {
            this.gedungId = entity.getGedungId();
            this.gedungName = entity.getGedung().getName();
        }
    }
}