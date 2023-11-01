package com.bootcamp.belajarspringjpa1.service;

import com.bootcamp.belajarspringjpa1.entity.PropertyEntity;
import com.bootcamp.belajarspringjpa1.model.PropertyDto;

import java.util.List;

public interface PropertyService {

    List<PropertyEntity> getAll();
    PropertyEntity getById(Integer id);
    PropertyEntity save(PropertyDto request);
    PropertyEntity delete(Integer id);
    PropertyEntity update(Integer id, PropertyDto request);
}
