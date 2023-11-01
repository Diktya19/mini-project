package com.bootcamp.latihan_spring.service;

import com.bootcamp.latihan_spring.entity.GudangEntity;
import com.bootcamp.latihan_spring.model.GudangDto;

import java.util.List;

public interface GudangService {
    List<GudangEntity> getAll();
    GudangEntity getById(Integer id);
    GudangEntity save(GudangDto request);
    GudangEntity delete(Integer id);
    GudangEntity update(Integer id, GudangDto request);
}
