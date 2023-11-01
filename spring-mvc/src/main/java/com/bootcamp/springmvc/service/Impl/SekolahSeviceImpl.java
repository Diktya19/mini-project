package com.bootcamp.springmvc.service.Impl;

import com.bootcamp.springmvc.model.SekolahDto;
import com.bootcamp.springmvc.entity.SekolahEntity;
import com.bootcamp.springmvc.repository.SekolahRepo;
import com.bootcamp.springmvc.service.SekolahService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Slf4j
public class SekolahSeviceImpl implements SekolahService {

    private final SekolahRepo repo;

    public SekolahSeviceImpl(SekolahRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<SekolahEntity> getAll() {
        return this.repo.findAll();
    }

    @Override
    public SekolahEntity getBtId(Integer id) {
        return this.repo.findById(id).orElse(null);
    }

    @Override
    public SekolahEntity save(SekolahDto request) {
        SekolahEntity result = new SekolahEntity();
        BeanUtils.copyProperties(request, result);
        try{
            this.repo.save(result);
            log.info("Save Data Sekolah to database successfully");
            return result;
        }catch (Exception er){
            log.error("Save Data Sekolah to database failed, error: {}", er.getMessage());
            return null;
        }
    }

    @Override
    public SekolahEntity update(Integer id, SekolahDto request) {
        SekolahEntity entity = this.repo.findById(id).orElse(null);
        if (entity == null){
            log.warn("Sekolah with id: {} not found", id);
            return null;
        }
        BeanUtils.copyProperties(request, entity);
        try{
            this.repo.save(entity);
            log.info("Update data Sekolah to database Successfully");
            return entity;
        }catch (Exception er){
            log.error("Update data Sekolah to databse failed, error: {}", er.getMessage());
            return null;
        }
    }

    @Override
    public SekolahEntity delete(Integer id) {
        SekolahEntity result = this.repo.findById(id).orElse(null);
        if (result == null){
            log.warn("Sekolah with id: {} not found", id);
            return null;
        }
        try{
            this.repo.delete(result);
            log.info("Delete data Sekolah from database successfully");
            return result;
        }catch (Exception er){
            log.error("Delete data Sekolah from databse failed, error: {} ", er.getMessage());
            return null;
        }
    }
}
