package com.siakad.springsiakad.model;

import com.siakad.springsiakad.entity.FakultasEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FakultasModel {
    private String id;
    private String code;
    private String name;
    private List<JurusanModel> jurusan = new ArrayList<>();

    public FakultasModel(FakultasEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
