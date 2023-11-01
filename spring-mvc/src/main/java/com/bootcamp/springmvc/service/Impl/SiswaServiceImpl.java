package com.bootcamp.springmvc.service.Impl;

import com.bootcamp.springmvc.entity.SiswaEntity;
import com.bootcamp.springmvc.model.SiswaDto;
import com.bootcamp.springmvc.repository.SiswaRepo;
import com.bootcamp.springmvc.service.SiswaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SiswaServiceImpl implements SiswaService {

    private final SiswaRepo repo;

    public SiswaServiceImpl(SiswaRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<SiswaEntity> getAll() {
        return this.repo.findAll();
    }

    @Override
    public SiswaEntity getById(Integer id) {
        return this.repo.findById(id).orElse(null);
    }

    @Override
    public SiswaEntity save(SiswaDto request) {
        SiswaEntity result = new SiswaEntity();

        BeanUtils.copyProperties(request, result);
        try{
            this.repo.save(result);
            log.info("Save data Siswa to database successfully");
            return result;
        }catch (Exception er){
            log.error("Save data siswa to database failed, error: {}", er.getMessage());
            return null;
        }
    }

    @Override
    public SiswaEntity update(Integer id, SiswaDto request) {
        SiswaEntity entity = this.repo.findById(id).orElse(null);
        if (entity == null){
            log.warn("Data Siswa with id: {} not found", id);
            return null;
        }
        BeanUtils.copyProperties(request, entity);
        try {
            this.repo.save(entity);
            log.info("Update data Siswa to database successfully");
            return entity;
        }catch (Exception er){
            log.error("Update data Siswa to databse failed, error: {}", er.getMessage());
            return null;
        }
    }

    @Override
    public SiswaEntity delete(Integer id) {
        SiswaEntity product = this.repo.findById(id).orElse(null);
        if (product == null){
            log.warn("Data Siswa with id: {} not found", id);
            return null;
        }
        try{
            this.repo.delete(product);
            log.info("Delete data Siswa from database successfully");
            return product;
        }catch (Exception er){
            log.error("Delete data Siswa from database failed, error: {}", er.getMessage());
            return null;
        }
    }
}
