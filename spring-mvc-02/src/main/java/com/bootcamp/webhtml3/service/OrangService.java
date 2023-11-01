package com.bootcamp.webhtml3.service;

import com.bootcamp.webhtml3.dto.OrangDto;
import com.bootcamp.webhtml3.entity.OrangEntity;

import java.util.List;

public interface OrangService {
    List<OrangEntity> getAll();
    OrangEntity getById(Integer id);
    OrangEntity save(OrangDto request);
    OrangEntity update(Integer id, OrangDto request);
    OrangEntity delete(Integer id);
}
