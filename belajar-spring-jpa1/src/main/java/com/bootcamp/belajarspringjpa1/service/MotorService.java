package com.bootcamp.belajarspringjpa1.service;

import com.bootcamp.belajarspringjpa1.entity.MotorEntity;
import com.bootcamp.belajarspringjpa1.model.MotorDto;


import java.util.List;

public interface MotorService {

    List<MotorEntity> getAll();
    MotorEntity getById(Integer id);
    MotorEntity save(MotorDto request);
    MotorEntity delete(Integer id);
    MotorEntity update(Integer id, MotorDto request);
}
