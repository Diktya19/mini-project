package com.bootcamp.mvc01.service;

import com.bootcamp.mvc01.dto.SiswaDto;
import com.bootcamp.mvc01.entity.SiswaEntity;

import java.util.List;

public interface SiswaService {
    List<SiswaEntity> getAll();
    SiswaEntity getById(Integer id);
    SiswaEntity save(SiswaDto request);
    SiswaEntity update(Integer id, SiswaDto request);
    SiswaEntity delete(Integer id);
}
