package com.bootcamp.belajarspringjpa1.service.impl;

import com.bootcamp.belajarspringjpa1.entity.MotorEntity;
import com.bootcamp.belajarspringjpa1.model.MotorDto;
import com.bootcamp.belajarspringjpa1.repository.MotorRepo;
import com.bootcamp.belajarspringjpa1.service.MotorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MotorImpl implements MotorService {

    private MotorRepo motorRepo;

    public MotorImpl(MotorRepo motorRepo) {
        this.motorRepo = motorRepo;
    }

    @Override
    public List<MotorEntity> getAll() {
        return motorRepo.findAll();
    }

    @Override
    public MotorEntity getById(Integer id) {
        return motorRepo.findById(id).orElse(new MotorEntity());
    }

    @Override
    public MotorEntity save(MotorDto request) {
        MotorEntity result = new MotorEntity();

        result.setId(request.getId());
        result.setNama(request.getNama());
        result.setTipeMesin(request.getTipeMesin());
        result.setCc(request.getCc());
        result.setTransmisi(request.getTransmisi());
        result.setKompresi(request.getKompresi());
        result.setBahanBakar(request.getBahanBakar());
        result.setTorsi(request.getTorsi());
        result.setStarter(request.getStarter());
        result.setKopling(request.getKopling());
        result.setPendinginMesin(request.getPendinginMesin());
        result.setHarga(request.getHarga());
        result.setStok(request.getStok());

        try{
            motorRepo.save(result);
            log.info("Save data motor to database successfully");
            return result;
        } catch (Exception e){
            log.error("Save data motor to database failed, error: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public MotorEntity delete(Integer id) {
        MotorEntity entity = motorRepo.findById(id).orElse(null);
        if (entity == null){
            log.info("Data motor with id: {} not found", id);
            return null;
        }

        try{
            motorRepo.delete(entity);
            log.info("Delete data motor from database successfully");
            return entity;
        } catch (Exception e){
            log.error("Delete data motor from databse failed, error: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public MotorEntity update(Integer id, MotorDto request) {
        MotorEntity entity = motorRepo.findById(id).orElse(null);
        if (entity == null){
            log.info("Data motor with id: {} not found", id);
            return null;
        }
        entity.setId(request.getId());
        entity.setNama(request.getNama());
        entity.setTipeMesin(request.getTipeMesin());
        entity.setCc(request.getCc());
        entity.setTransmisi(request.getTransmisi());
        entity.setKompresi(request.getKompresi());
        entity.setBahanBakar(request.getBahanBakar());
        entity.setTorsi(request.getTorsi());
        entity.setStarter(request.getStarter());
        entity.setKopling(request.getKopling());
        entity.setPendinginMesin(request.getPendinginMesin());
        entity.setHarga(request.getHarga());
        entity.setStok(request.getStok());

        try{
            motorRepo.save(entity);
            log.info("Update data motor to database successfully");
            return entity;
        } catch (Exception e){
            log.error("Update data motor to database failed, error: {}", e.getMessage());
            return null;
        }
    }
}
