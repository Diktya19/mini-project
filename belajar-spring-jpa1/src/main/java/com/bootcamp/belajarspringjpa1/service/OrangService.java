package com.bootcamp.belajarspringjpa1.service;

import com.bootcamp.belajarspringjpa1.entity.OrangEntity;
import com.bootcamp.belajarspringjpa1.model.OrangDto;

import java.util.List;

public interface OrangService {

    List<OrangEntity> getAll();
    OrangEntity getById(Integer id);
    OrangEntity save(OrangDto request);
    OrangEntity delete(Integer id);
    OrangEntity update(Integer id, OrangDto request);
}
