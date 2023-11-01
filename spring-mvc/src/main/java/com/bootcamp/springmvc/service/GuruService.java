package com.bootcamp.springmvc.service;

import com.bootcamp.springmvc.entity.GuruEntity;
import com.bootcamp.springmvc.model.GuruDto;

import java.util.List;

public interface GuruService {
    List<GuruEntity> getAll();
    GuruEntity getById(Integer id);
    GuruEntity save(GuruDto request);
    GuruEntity update(Integer id, GuruDto request);
    GuruEntity delete(Integer id);
}
