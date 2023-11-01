package com.bootcamp.springmvc.service.Impl;

import com.bootcamp.springmvc.repository.KameraRepo;
import com.bootcamp.springmvc.service.KameraService;
import com.bootcamp.springmvc.entity.KameraEntity;
import com.bootcamp.springmvc.model.KameraDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class KameraServiceImpl implements KameraService {

    private final KameraRepo repo;

    public KameraServiceImpl(KameraRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<KameraEntity> getAll() {
        return this.repo.findAll();
    }

    @Override
    public KameraEntity getById(Integer id) {
        return this.repo.findById(id).orElse(null);
    }

    @Override
    public KameraEntity save(KameraDto request) {
        KameraEntity result = new KameraEntity();
        BeanUtils.copyProperties(request, result);

        try{
            this.repo.save(result);
            log.info("Save data Kamera to database succesfully");
            return result;
        }catch (Exception er){
            log.error("Save data Kamera to database failed, error: {}", er.getMessage());
            return null;
        }
    }

    @Override
    public KameraEntity update(Integer id, KameraDto request) {
        KameraEntity entity = this.repo.findById(id).orElse(null);
        if (entity == null){
            log.warn("Data Kamera with id: {} not found", id);
            return null;
        }
        BeanUtils.copyProperties(request, entity);
        try{
            this.repo.save(entity);
            log.info("Update data Kamera to database successfully");
            return entity;
        }catch (Exception er){
            log.error("Update data to database failed, error: {}", er.getMessage());
            return null;
        }
    }

    @Override
    public KameraEntity delete(Integer id) {
        KameraEntity product = this.repo.findById(id).orElse(null);
        if (product == null){
            log.warn("Data Kamera with id: {} not found", id);
            return null;
        }
        try{
            this.repo.delete(product);
            log.info("Delete data Kamera from database successfully");
            return product;
        }catch (Exception er){
            log.error("Delete data Kamera from database failed, error: {}", er.getMessage());
            return null;
        }
    }
}
