package com.bootcamp.belajarspringjpa1.service;

import com.bootcamp.belajarspringjpa1.entity.CafeEntity;
import com.bootcamp.belajarspringjpa1.model.CafeDto;

import java.util.List;

public interface CafeService {

    List<CafeEntity> getAll();
    CafeEntity getById(Integer id);
    CafeEntity save(CafeDto request);
    CafeEntity delete(Integer id);
    CafeEntity update(Integer id, CafeDto request);
}
