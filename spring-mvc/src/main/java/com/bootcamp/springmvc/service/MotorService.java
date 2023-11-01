package com.bootcamp.springmvc.service;

import com.bootcamp.springmvc.entity.MotorEntity;
import com.bootcamp.springmvc.model.MotorDto;

import java.util.List;

public interface MotorService {

    List<MotorEntity> getAll();
    MotorEntity getById(Integer id);
    MotorEntity save(MotorDto request);
    MotorEntity update(Integer id, MotorDto request);
    MotorEntity delete(Integer id);
}
