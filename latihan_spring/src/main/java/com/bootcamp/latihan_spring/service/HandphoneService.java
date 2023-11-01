package com.bootcamp.latihan_spring.service;

import com.bootcamp.latihan_spring.entity.HandphoneEntity;
import com.bootcamp.latihan_spring.model.HandphoneDto;

import java.util.List;

public interface HandphoneService {
    List<HandphoneEntity> getAll();
    HandphoneEntity getById(Integer id);
    HandphoneEntity save(HandphoneDto request);
    HandphoneEntity delete(Integer id);
    HandphoneEntity update(Integer id, HandphoneDto request);
}
