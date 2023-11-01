package com.bootcamp.latihan_spring.service.impl;

import com.bootcamp.latihan_spring.entity.GuruEntity;
import com.bootcamp.latihan_spring.model.GuruDto;
import com.bootcamp.latihan_spring.repository.GuruRepo;
import com.bootcamp.latihan_spring.service.GuruService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j

public class GuruImpl implements GuruService {
    private GuruRepo guruRepo;

    public GuruImpl(GuruRepo guruRepo) {
        this.guruRepo = guruRepo;
    }

    @Override
    public List<GuruEntity> getAll() {
        return guruRepo.findAll();
    }

    @Override
    public GuruEntity getById(Integer id) {
        return guruRepo.findById(id).orElse(new GuruEntity());
    }

    @Override
    public GuruEntity save(GuruDto request) {
        GuruEntity result = new GuruEntity();
        result.setId(request.getId());
        result.setNama(request.getNama());
        result.setTtl(request.getTtl());
        result.setJk(request.getJk());
        result.setAgama(request.getAgama());
        result.setAlamat(request.getAlamat());
        result.setSekolah(request.getSekolah());
        result.setMapel(request.getMapel());
        result.setWaktu(request.getWaktu());

        try{
            guruRepo.save(result);
            log.info("Save data Guru to database successfully");
            return result;
        } catch (Exception e){
            log.error("Save data Guru to databse failed, error: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public GuruEntity delete(Integer id) {
        GuruEntity entity = guruRepo.findById(id).orElse(null);
        if (entity == null){
            log.info("Data Guru with id: {} not found", id);
            return null;
        }
        try{
            guruRepo.delete(entity);
            log.info("Delete data guru from database successfully");
            return entity;
        } catch (Exception e){
            log.error("Delete data Guru from database failed, error: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public GuruEntity update(Integer id, GuruDto request) {
        GuruEntity entity = guruRepo.findById(id).orElse(null);
        if (entity == null){
            log.info("Data Guru with id: {} not found", id);
            return null;
        }
        entity.setId(request.getId());
        entity.setNama(request.getNama());
        entity.setTtl(request.getTtl());
        entity.setJk(request.getJk());
        entity.setAgama(request.getAgama());
        entity.setAlamat(request.getAlamat());
        entity.setSekolah(request.getSekolah());
        entity.setMapel(request.getMapel());
        entity.setWaktu(request.getWaktu());

        try{
            guruRepo.save(entity);
            log.info("Update data Guru to database successfully");
            return entity;
        } catch (Exception e){
            log.error("Update data Guru to database failed, error: {}", e.getMessage());
            return null;
        }
    }
}
