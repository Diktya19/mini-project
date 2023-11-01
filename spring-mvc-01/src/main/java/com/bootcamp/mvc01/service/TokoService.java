package com.bootcamp.mvc01.service;

import com.bootcamp.mvc01.dto.TokoDto;
import com.bootcamp.mvc01.entity.TokoEntity;

import java.util.List;

public interface TokoService {
    List<TokoEntity> getAll();
    TokoEntity getById(Integer id);
    TokoEntity save(TokoDto request);
    TokoEntity update(Integer id, TokoDto request);
    TokoEntity delete(Integer id);
}
