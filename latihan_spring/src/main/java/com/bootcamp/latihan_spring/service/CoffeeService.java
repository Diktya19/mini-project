package com.bootcamp.latihan_spring.service;

import com.bootcamp.latihan_spring.entity.CoffeeEntity;
import com.bootcamp.latihan_spring.model.CoffeeDto;

import java.util.List;

public interface CoffeeService {
    List<CoffeeEntity> getAll();
    CoffeeEntity getByid(Integer id);
    CoffeeEntity save(CoffeeDto request);
    CoffeeEntity delete(Integer id);
    CoffeeEntity update(Integer id, CoffeeDto request);
}