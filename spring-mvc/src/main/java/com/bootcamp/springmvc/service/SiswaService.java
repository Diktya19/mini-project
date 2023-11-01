package com.bootcamp.springmvc.service;

import com.bootcamp.springmvc.entity.SiswaEntity;
import com.bootcamp.springmvc.model.SiswaDto;

import java.util.List;

public interface SiswaService {
    List<SiswaEntity> getAll();
    SiswaEntity getById(Integer id);
    SiswaEntity save(SiswaDto request);
    SiswaEntity update(Integer id, SiswaDto request);
    SiswaEntity delete(Integer id);
}
