package com.bootcamp.springmvc.service;

import com.bootcamp.springmvc.model.SekolahDto;
import com.bootcamp.springmvc.entity.SekolahEntity;

import java.util.List;

public interface SekolahService {
    List<SekolahEntity> getAll();
    SekolahEntity getBtId(Integer id);
    SekolahEntity save(SekolahDto request);
    SekolahEntity update(Integer id, SekolahDto request);
    SekolahEntity delete(Integer id);
}
