package com.bootcamp.belajarspringjpa1.service.impl;

import com.bootcamp.belajarspringjpa1.entity.OrangEntity;
import com.bootcamp.belajarspringjpa1.model.OrangDto;
import com.bootcamp.belajarspringjpa1.repository.OrangRepo;
import com.bootcamp.belajarspringjpa1.service.OrangService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OrangServiceImpl implements OrangService {

    private OrangRepo orangRepo;

    public OrangServiceImpl(OrangRepo orangRepo) {
        this.orangRepo = orangRepo;
    }

    @Override
    public List<OrangEntity> getAll() {
        return orangRepo.findAll();
    }

    @Override
    public OrangEntity getById(Integer id) {
        return orangRepo.findById(id).orElse(new OrangEntity());
    }

    @Override
    public OrangEntity save(OrangDto request) {

        OrangEntity result = new OrangEntity();
        result.setId(request.getId());
        result.setNama(request.getNama());
        result.setTtl(request.getTtl());
        result.setAgama(request.getAgama());
        result.setJk(request.getJk());
        result.setTb(request.getTb());
        result.setBb(request.getBb());
        result.setUmur(request.getUmur());
        result.setAlamat(request.getAlamat());
        result.setNamaOrtu(request.getNamaOrtu());
        result.setNoHp(request.getNoHp());

        try{
            orangRepo.save(result);
            log.info("Save data Orang to databse successfully");
            return result;
        } catch (Exception e){
            log.error("Save data Orang to database failed, error: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public OrangEntity delete(Integer id) {
        OrangEntity entity = orangRepo.findById(id).orElse(null);
        if (entity == null){
            log.info("Data Orang with id: {} not found", id);
            return null;
        }

        try{
            orangRepo.delete(entity);
            log.info("Delete data orang from database successfully");
            return entity;
        } catch (Exception e){
            log.error("Delete data Orang form database failed, error: {}", e.getMessage());
            return null;
        }
    }


    @Override
    public OrangEntity update(Integer id, OrangDto request) {
        OrangEntity entity = orangRepo.findById(id).orElse(null);
        if (entity == null){
            log.info("Data Orang with id: {} not found", id);
            return null;
        }
        entity.setId(request.getId());
        entity.setNama(request.getNama());
        entity.setTtl(request.getTtl());
        entity.setAgama(request.getAgama());
        entity.setJk(request.getJk());
        entity.setTb(request.getTb());
        entity.setBb(request.getBb());
        entity.setUmur(request.getUmur());
        entity.setAlamat(request.getAlamat());
        entity.setNamaOrtu(request.getNamaOrtu());
        entity.setNoHp(request.getNoHp());

        try{
            orangRepo.save(entity);
            log.info("Update data Orang to database successfully");
            return entity;
        } catch (Exception e){
            log.error("Update data Orang to database failed, error: {}", e.getMessage());
            return null;
        }
    }
}
