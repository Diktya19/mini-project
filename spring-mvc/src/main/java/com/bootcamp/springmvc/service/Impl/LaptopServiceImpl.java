package com.bootcamp.springmvc.service.Impl;

import com.bootcamp.springmvc.repository.LaptopRepo;
import com.bootcamp.springmvc.entity.LaptopEntity;
import com.bootcamp.springmvc.model.LaptopDto;
import com.bootcamp.springmvc.service.LaptopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LaptopServiceImpl implements LaptopService {

    private LaptopRepo repo;

    public LaptopServiceImpl(LaptopRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<LaptopEntity> getAll() {
        return this.repo.findAll();
    }

    @Override
    public LaptopEntity getById(Integer id) {
        return this.repo.findById(id).orElse(null);
    }

    @Override
    public LaptopEntity save(LaptopDto request) {
        LaptopEntity result = new LaptopEntity();
        BeanUtils.copyProperties(request, result);
        try{
            this.repo. save(result);
            log.info("Save Data Laptop to database successfully");
            return result;
        }catch (Exception er){
            log.error("Save Data Laptop to database failed, error: {}", er.getMessage());
            return null;
        }
    }

    @Override
    public LaptopEntity update(Integer id, LaptopDto request) {
        LaptopEntity entity = this.repo.findById(id).orElse(null);
        if (entity == null){
            log.warn("Data Laptop with id: {} not found", id);
            return null;
        }
        BeanUtils.copyProperties(request, entity);
        try{
            this.repo.save(entity);
            log.info("Update data Laptop to database successfully");
            return entity;
        } catch (Exception er){
            log.error("Update data Laptop to database failed, error: {}", er.getMessage());
            return null;
        }
    }

    @Override
    public LaptopEntity delete(Integer id) {
        LaptopEntity entity = this.repo.findById(id).orElse(null);
        if (entity == null){
            log.warn("Data Laptop with id: {} not found");
            return null;
        }
        try{
            this.repo.delete(entity);
            log.info("Delete data laptop form database succesfully");
            return entity;
        }catch (Exception er){
            log.error("Delete data Laptop from database failed, error: {}", er.getMessage());
            return null;
        }
    }
}
