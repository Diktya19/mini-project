package com.bootcamp.springmvc.service.Impl;

import com.bootcamp.springmvc.repository.MotorRepo;
import com.bootcamp.springmvc.entity.MotorEntity;
import com.bootcamp.springmvc.model.MotorDto;
import com.bootcamp.springmvc.service.MotorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MotorServiceImpl implements MotorService {

    private final MotorRepo repo;

    public MotorServiceImpl(MotorRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<MotorEntity> getAll() {
        return this.repo.findAll();
    }

    @Override
    public MotorEntity getById(Integer id) {
        return this.repo.findById(id).orElse(null);
    }

    @Override
    public MotorEntity save(MotorDto request) {
        MotorEntity result = new MotorEntity();
        BeanUtils.copyProperties(request, result);

        try{
            this.repo.save(result);
            log.info("Save data Motor to database successfully");
            return result;
        } catch (Exception er){
            log.error("Save data Motor to database failed, error: {}", er.getMessage());
            return null;
        }
    }

    @Override
    public MotorEntity update(Integer id, MotorDto request) {
        MotorEntity entity = this.repo.findById(id).orElse(null);
        if (entity == null){
            log.warn("Data motor with id: {} not found", id);
            return null;
        }
        BeanUtils.copyProperties(request, entity);
        try{
            this.repo.save(entity);
            log.info("Save data Motor to database successfully");
            return entity;
        } catch (Exception er){
            log.error("Save data Motor to database failed, error: {}", er.getMessage());
            return null;
        }
    }

    @Override
    public MotorEntity delete(Integer id) {
        MotorEntity result = this.repo.findById(id).orElse(null);
        if (result == null){
            log.warn("Delete data Moto with id: {} not found", id);
            return null;
        }
        try{
            this.repo.delete(result);
            log.info("Delete data Motor from database succesfully");
            return result;
        } catch (Exception er){
            log.error("Delete data motor from database failed, error: {}", er.getMessage());
            return null;
        }
    }
}
