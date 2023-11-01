package com.bootcamp.latihan_spring.service;

import com.bootcamp.latihan_spring.entity.KelasEntity;
import com.bootcamp.latihan_spring.model.KelasDto;


import java.util.List;

public interface KelasService {

    List<KelasEntity> getAll();
    KelasEntity getById(Integer id);
    KelasEntity save(KelasDto request);
    KelasEntity delete(Integer id);
    KelasEntity update(Integer id, KelasDto request);
}
