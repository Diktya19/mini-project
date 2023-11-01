package com.bootcamp.mvc01.impl;

import com.bootcamp.mvc01.dto.TokoDto;
import com.bootcamp.mvc01.entity.TokoEntity;
import com.bootcamp.mvc01.repository.TokoRepo;
import com.bootcamp.mvc01.service.TokoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TokoImpl implements TokoService {
    private final TokoRepo repo;

    public TokoImpl(TokoRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<TokoEntity> getAll() {
        return this.repo.findAll();
    }

    @Override
    public TokoEntity getById(Integer id) {
        return this.repo.findById(id).orElse(null);
    }

    @Override
    public TokoEntity save(TokoDto request) {
        TokoEntity result = new TokoEntity();
        BeanUtils.copyProperties(request, result);
        try{
            this.repo.save(result);
            log.info("Save data Toko to database successfully");
            return result;
        }catch (Exception er){
            log.error("Save data toko to database failed, error: {}", er.getMessage());
            return null;
        }
    }

    @Override
    public TokoEntity update(Integer id, TokoDto request) {
        TokoEntity entity = this.repo.findById(id).orElse(null);
        if (entity == null){
            log.warn("Data Toko with id: {} not found",id);
            return null;
        }
        BeanUtils.copyProperties(request, entity);
        try{
            this.repo.save(entity);
            log.info("Update data Toko to database successfully");
            return entity;
        }catch (Exception er){
            log.error("Update data Toko to database failed, error: {}", er.getMessage());
            return null;
        }
    }

    @Override
    public TokoEntity delete(Integer id) {
        TokoEntity result = this.repo.findById(id).orElse(null);
        if (result == null) {
            log.warn("Data Toko with id: {} not found", id);
            return null;
        }
        try{
            this.repo.delete(result);
            log.info("Delete data Toko from database successfully");
            return result;
        }catch (Exception er) {
            log.error("Delete data Toko from database failed, error: {}",er.getMessage());
            return null;
        }
    }
}