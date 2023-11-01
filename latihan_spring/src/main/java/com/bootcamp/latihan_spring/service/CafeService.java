package com.bootcamp.latihan_spring.service;

import com.bootcamp.latihan_spring.entity.CafeEntity;
import com.bootcamp.latihan_spring.model.CafetariaDto;

import java.util.List;

public interface CafeService {
    List<CafeEntity> getAll();
    CafeEntity getById(Integer id);
    CafeEntity save(CafetariaDto request);
    CafeEntity delete(Integer id);
    CafeEntity update(Integer id, CafetariaDto request);
}
