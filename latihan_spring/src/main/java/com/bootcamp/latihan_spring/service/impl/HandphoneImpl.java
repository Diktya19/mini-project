package com.bootcamp.latihan_spring.service.impl;

import com.bootcamp.latihan_spring.entity.HandphoneEntity;
import com.bootcamp.latihan_spring.model.HandphoneDto;
import com.bootcamp.latihan_spring.repository.HandphoneRepo;
import com.bootcamp.latihan_spring.service.HandphoneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class HandphoneImpl implements HandphoneService {
    private HandphoneRepo handphoneRepo;
    public HandphoneImpl(HandphoneRepo handphoneRepo) {
        this.handphoneRepo = handphoneRepo;
    }

    @Override
    public List<HandphoneEntity> getAll() {
        return handphoneRepo.findAll();
    }

    @Override
    public HandphoneEntity getById(Integer id) {
        return handphoneRepo.findById(id).orElse(new HandphoneEntity());
    }

    @Override
    public HandphoneEntity save(HandphoneDto request) {
        HandphoneEntity result = new HandphoneEntity();
        result.setId(request.getId());
        result.setNama(request.getNama());
        result.setMerk(request.getMerk());
        result.setRam(request.getRam());
        result.setLayar(request.getLayar());
        result.setKameraDepan(request.getKameraDepan());
        result.setKameraBelakang(request.getKameraBelakang());
        result.setWarna(request.getWarna());
        result.setPenyimpanan(request.getPenyimpanan());
        result.setBateri(request.getBateri());
        result.setDimensi(request.getDimensi());
        result.setTahunRilis(request.getTahunRilis());
        result.setOs(request.getOs());

        try{
            handphoneRepo.save(result);
            log.info("Save data handphone to database succesfully");
            return result;
        } catch (Exception e){
            log.error("Save data Handphone to database failed, error: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public HandphoneEntity delete(Integer id) {
        HandphoneEntity entity = handphoneRepo.findById(id).orElse(null);
        if (entity == null){
            log.info("Data Handphone with id: {} not found", id);
            return null;
        }
        try{
            handphoneRepo.delete(entity);
            log.info("Delete data handpone from database succesfully");
            return entity;
        } catch (Exception e){
            log.error("Delete data handphone form database failed, error: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public HandphoneEntity update(Integer id, HandphoneDto request) {
        HandphoneEntity entity = handphoneRepo.findById(id).orElse(null);
        if (entity == null){
            log.info("Data Handphone with id: {} not found", id);
            return null;
        }
        entity.setId(request.getId());
        entity.setNama(request.getNama());
        entity.setMerk(request.getMerk());
        entity.setRam(request.getRam());
        entity.setLayar(request.getLayar());
        entity.setKameraDepan(request.getKameraDepan());
        entity.setKameraBelakang(request.getKameraBelakang());
        entity.setWarna(request.getWarna());
        entity.setPenyimpanan(request.getPenyimpanan());
        entity.setBateri(request.getBateri());
        entity.setDimensi(request.getDimensi());
        entity.setTahunRilis(request.getTahunRilis());
        entity.setOs(request.getOs());

        try{
            handphoneRepo.save(entity);
            log.info("Update data Handphone to database successfully");
            return entity;
        } catch (Exception e){
            log.error("Update data Handphone to database failed, error: {}", e.getMessage());
            return null;
        }
    }
}
