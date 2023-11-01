package com.bootcamp.springmvc.service;

import com.bootcamp.springmvc.entity.KameraEntity;
import com.bootcamp.springmvc.model.KameraDto;

import java.util.List;

public interface KameraService {

    List<KameraEntity> getAll();
    KameraEntity getById(Integer id);
    KameraEntity save(KameraDto request);
    KameraEntity update(Integer id, KameraDto request);
    KameraEntity delete(Integer id);
}
