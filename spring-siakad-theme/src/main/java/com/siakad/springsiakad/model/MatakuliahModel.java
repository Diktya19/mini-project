package com.siakad.springsiakad.model;

import com.siakad.springsiakad.entity.MatakuliahEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatakuliahModel {
    private String id;
    private String code;
    private String name;
    private Integer sks;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updateAt;
    private  String updateBy;

    public MatakuliahModel(MatakuliahEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
