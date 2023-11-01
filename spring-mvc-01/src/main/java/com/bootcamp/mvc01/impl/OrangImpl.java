package com.bootcamp.mvc01.impl;

import com.bootcamp.mvc01.dto.OrangDto;
import com.bootcamp.mvc01.entity.OrangEntity;
import com.bootcamp.mvc01.repository.OrangRepo;
import com.bootcamp.mvc01.service.OrangService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OrangImpl implements OrangService {
    private final OrangRepo repo;

    public OrangImpl(OrangRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<OrangEntity> getAll() {
        return this.repo.findAll();
    }

    @Override
    public OrangEntity getById(Integer id) {
        return this.repo.findById(id).orElse(null);
    }

    @Override
    public OrangEntity save(OrangDto request) {
        OrangEntity result = new OrangEntity();
        BeanUtils.copyProperties(request, result);
        try{
            this.repo.save(result);
            log.info("Save data Orang to database successfully");
            return result;
        }catch (Exception e){
            log.error("Save data Orang to database failed, error: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public OrangEntity update(Integer id, OrangDto request) {
        OrangEntity entity = this.repo.findById(id).orElse(null);
        if (entity == null){
            log.warn("Data orang with id: {} not found", id);
            return null;
        }
        BeanUtils.copyProperties(entity, request);
        try{
            this.repo.save(entity);
            log.info("Update data Orang to database sucessfully");
            return entity;
        }catch (Exception e){
            log.error("Update data Orang to database failed, error: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public OrangEntity delete(Integer id) {
        OrangEntity result = this.repo.findById(id).orElse(null);
        if (result == null){
            log.warn("Data Orang with id: {} not found", id);
            return null;
        }
        try{
            this.repo.delete(result);
            log.info("Delete data Orang from database successfully");
            return result;
        }catch (Exception er){
            log.error("Delete data Orang from database failed, error: {}", er.getMessage());
            return null;
        }
    }
}
