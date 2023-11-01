package com.bootcamp.springmvc.service.Impl;

import com.bootcamp.springmvc.repository.HandphoneRepo;
import com.bootcamp.springmvc.entity.HandphoneEntity;
import com.bootcamp.springmvc.model.HandphoneDto;
import com.bootcamp.springmvc.service.HandphoneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class HandphoneServiceImpl implements HandphoneService {

    private final HandphoneRepo repo;

    public HandphoneServiceImpl(HandphoneRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<HandphoneEntity> getAll() {
        return this.repo.findAll();
    }

    @Override
    public HandphoneEntity getById(Integer id) {
        return this.repo.findById(id).orElse(null);
    }

    @Override
    public HandphoneEntity save(HandphoneDto request) {
        HandphoneEntity result = new HandphoneEntity();
        // cara mengcopy propertynya
        BeanUtils.copyProperties(request, result);
        try{
            // proses menyimpan data
            this.repo.save(result);
            log.info("Save data Handphone to database successfully");
            // di kembalikan nilainya dengan object result
            return result;
        } catch (Exception er){
            // jika terjadi error
            log.error("Sava data Handphone to database error: {}", er.getMessage());
            return null;
        }
    }

    @Override
    public HandphoneEntity update(Integer id, HandphoneDto request) {
        // get data by id dari database
        HandphoneEntity entity = this.repo.findById(id).orElse(null);
        // validasi data
        if (entity == null){
            log.warn("Data Handphone with id: {} not found", id);
            return null;
        }
        // copy property
        BeanUtils.copyProperties(request, entity);
        try{
            // proses update ke database
            this.repo.save(entity);
            log.info("Update data Handphone to database successfully");
            // kembalikan nilainya ke object entity
            return entity;
        }catch (Exception er){
            // jika saat update error
            log.error("Update data Handphone to database failed, error: {}", er.getMessage());
            // kembalikan nilainya ke null
            return null;
        }
    }

    @Override
    public HandphoneEntity delete(Integer id) {
        // get form database
        HandphoneEntity entity = this.repo.findById(id).orElse(null);
        // validasi data
        if (entity == null){
            log.warn("Data Handphone with id: {} not found", id);
            // kembalikan datanya ke null
            return null;
        }

        // kalau data ketemu dengan id yg di parameter
        try{
            // proses delete dari database
            this.repo.delete(entity);
            log.info("Delete data Handphone form database succesfully");
            // kembalikan datanya ke object entity
            return entity;
        } catch (Exception er){
            // jika saat delete terjadi error
            log.error("Delete data Handphone from database failed, error: {}", er.getMessage());
            return null;
        }
    }
}
