package com.bootcamp.webhtml3.impl;

import com.bootcamp.webhtml3.dto.OrangDto;
import com.bootcamp.webhtml3.entity.OrangEntity;
import com.bootcamp.webhtml3.repository.OrangRepo;
import com.bootcamp.webhtml3.service.OrangService;
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
        try {
            this.repo.save(result);
            log.info("Save data Orang to database successfully");
            return result;
        }catch (Exception er){
            log.error("Save data Orang to database failed, error: {}", er.getMessage());
            return null;
        }
    }

    @Override
    public OrangEntity update(Integer id, OrangDto request) {
        OrangEntity entity = this.repo.findById(id).orElse(null);
        if (entity == null){
            log.warn("Data Orang with id: {} not found", id);
            return null;
        }
        BeanUtils.copyProperties(request, entity);
        try{
            this.repo.save(entity);
            log.info("Update data Orang to database succesfully");
            return entity;
        }catch (Exception er){
            log.error("Update data Orang to database failed, error: {}", er.getMessage());
            return null;
        }
    }

    @Override
    public OrangEntity delete(Integer id) {
        OrangEntity result = this.repo.findById(id).orElse(null);
        if (result == null){
            log.warn("Data Orang with id: {} not found",id);
            return null;
        }
        try{
            this.repo.delete(result);
            log.info("Delete data Orang to database successfully");
            return result;
        }catch (Exception er){
            log.error("Delete data Orang to database failed, error: {}", er.getMessage());
            return null;
        }
    }
}
