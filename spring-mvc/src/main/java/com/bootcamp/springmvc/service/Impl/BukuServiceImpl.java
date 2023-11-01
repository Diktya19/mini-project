package com.bootcamp.springmvc.service.Impl;

import com.bootcamp.springmvc.repository.BukuRepo;
import com.bootcamp.springmvc.entity.BukuEntity;
import com.bootcamp.springmvc.model.BukuDto;
import com.bootcamp.springmvc.service.BukuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BukuServiceImpl implements BukuService {

    private final BukuRepo repo;

    public BukuServiceImpl(BukuRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<BukuEntity> getAll() {
        return this.repo.findAll();
    }

    @Override
    public BukuEntity getById(Integer id) {
        return this.repo.findById(id).orElse(null);
    }

    @Override
    public BukuEntity save(BukuDto request) {
        BukuEntity result = new BukuEntity();
        BeanUtils.copyProperties(request, result);
        try{
            this.repo.save(result);
            log.info("Save data Buku to database successfully");
            return result;
        }catch (Exception er){
            log.error("Save data Buku to database failed, error: {}", er.getMessage());
            return null;
        }
    }

    @Override
    public BukuEntity update(Integer id, BukuDto request) {
        BukuEntity entity = this.repo.findById(id).orElse(null);
        if (entity == null){
            log.warn("Data Buku with id: {} not found", id);
            return null;
        }
        BeanUtils.copyProperties(request, entity);
        try{
            this.repo.save(entity);
            log.info("Update data Buku to database successfully");
            return entity;
        } catch (Exception ex){
            log.error("Update data Buku to database failed, error: {}", ex.getMessage());
            return null;
        }
    }

    @Override
    public BukuEntity delete(Integer id) {
        BukuEntity result = this.repo.findById(id).orElse(null);
        if (result == null){
            log.warn("Data Buku with id: {} not found", id);
            return null;
        }
        try{
            this.repo.delete(result);
            log.info("Delete data Buku from database successfully");
            return result;
        }catch (Exception er){
            log.error("Delete data Buku from database failed, error: {}", er.getMessage());
            return null;
        }
    }
}
