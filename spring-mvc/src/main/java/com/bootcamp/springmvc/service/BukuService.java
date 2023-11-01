package com.bootcamp.springmvc.service;

import com.bootcamp.springmvc.entity.BukuEntity;
import com.bootcamp.springmvc.model.BukuDto;

import java.util.List;

public interface BukuService {

    List<BukuEntity> getAll();
    BukuEntity getById(Integer id);
    BukuEntity save(BukuDto request);
    BukuEntity update(Integer id, BukuDto request);
    BukuEntity delete(Integer id);
}
