package com.bootcamp.springmvc.service.Impl;

import com.bootcamp.springmvc.entity.GuruEntity;
import com.bootcamp.springmvc.model.GuruDto;
import com.bootcamp.springmvc.repository.GuruRepo;
import com.bootcamp.springmvc.service.GuruService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class GuruImpl implements GuruService {

    private final GuruRepo repo;

    public GuruImpl(GuruRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<GuruEntity> getAll() {
        return this.repo.findAll();
    }

    @Override
    public GuruEntity getById(Integer id) {
        return this.repo.findById(id).orElse(null);
    }

    @Override
    public GuruEntity save(GuruDto request) {
        GuruEntity result = new GuruEntity();
        BeanUtils.copyProperties(request, result);
        try{
            this.repo.save(result);
            log.info("Save data Guru to database successfully");
            return result;
        }catch (Exception er){
            log.error("Save data Guru to database failed, error: {}", er.getMessage());
            return null;
        }
    }

    @Override
    public GuruEntity update(Integer id, GuruDto request) {
        GuruEntity entity = this.repo.findById(id).orElse(null);
        if (entity == null){
            log.warn("Data Guru with id: {} not found", id);
            return null;
        }
        BeanUtils.copyProperties(request, entity);
        try{
            this.repo.save(entity);
            log.info("Update data Guru to database successfully");
            return entity;
        }catch (Exception er){
            log.error("Update data Guru to database failed, error: {}", er.getMessage());
            return null;
        }
    }

    @Override
    public GuruEntity delete(Integer id) {
        GuruEntity product = this.repo.findById(id).orElse(null);
        if (product == null){
            log.warn("Data Guru with Id: {} not found", id);
            return null;
        }
        try{
            this.repo.delete(product);
            log.info("Delete data Guru from database successfully");
            return product;
        }catch (Exception er){
            log.error("Delete data Guru from database failed, error: {}", er.getMessage());
            return null;
        }

    }
}
