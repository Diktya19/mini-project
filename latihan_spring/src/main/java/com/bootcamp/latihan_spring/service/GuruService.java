package com.bootcamp.latihan_spring.service;

import com.bootcamp.latihan_spring.entity.GuruEntity;
import com.bootcamp.latihan_spring.model.GuruDto;

import java.util.List;

public interface GuruService {
    List<GuruEntity> getAll();
    GuruEntity getById(Integer id);
    GuruEntity save(GuruDto request);
    GuruEntity delete(Integer id);
    GuruEntity update(Integer id, GuruDto request);
}
