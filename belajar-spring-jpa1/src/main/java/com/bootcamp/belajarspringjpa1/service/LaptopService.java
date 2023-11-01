package com.bootcamp.belajarspringjpa1.service;

import com.bootcamp.belajarspringjpa1.entity.LaptopEntity;
import com.bootcamp.belajarspringjpa1.model.LaptopDto;

import java.util.List;

public interface LaptopService {
    List<LaptopEntity> getAll();
    LaptopEntity getById(Integer id);
    LaptopEntity save(LaptopDto request);
    LaptopEntity delete(Integer id);
    LaptopEntity update(Integer id, LaptopDto request);
}
