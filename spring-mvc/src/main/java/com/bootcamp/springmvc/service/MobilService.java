package com.bootcamp.springmvc.service;

import com.bootcamp.springmvc.entity.MobilEntity;
import com.bootcamp.springmvc.model.MobilDto;

import java.util.List;

public interface MobilService {

    List<MobilEntity> getAll();
    MobilEntity getById(Integer id);
    MobilEntity save(MobilDto request);
    MobilEntity update(Integer id, MobilDto request);
    MobilEntity delete(Integer id);
}
