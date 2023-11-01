package com.siakad.springsiakad.model;

import com.siakad.springsiakad.entity.JurusanEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JurusanModel {
    private String id;
    private String code;
    private String name;
    private String fakultasId;
    private String fakultasName;

    public JurusanModel(JurusanEntity entity) {
        BeanUtils.copyProperties(entity, this);

        if (entity.getFakultas() != null){
            this.fakultasId = entity.getFakultas().getId();
            this.fakultasName = entity.getFakultas().getName();
        }
    }
}
