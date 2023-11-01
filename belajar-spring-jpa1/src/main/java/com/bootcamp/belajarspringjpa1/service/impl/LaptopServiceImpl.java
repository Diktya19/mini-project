package com.bootcamp.belajarspringjpa1.service.impl;

import com.bootcamp.belajarspringjpa1.entity.LaptopEntity;
import com.bootcamp.belajarspringjpa1.model.LaptopDto;
import com.bootcamp.belajarspringjpa1.repository.LaptopRepo;
import com.bootcamp.belajarspringjpa1.service.LaptopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LaptopServiceImpl implements LaptopService {

    private LaptopRepo laptopRepo;

    public LaptopServiceImpl(LaptopRepo laptopRepo) {
        this.laptopRepo = laptopRepo;
    }

    @Override
    public List<LaptopEntity> getAll() {
        return laptopRepo.findAll();
    }

    @Override
    public LaptopEntity getById(Integer id) {
        return laptopRepo.findById(id).orElse(new LaptopEntity());
    }

    @Override
    public LaptopEntity save(LaptopDto request) {

        LaptopEntity result = new LaptopEntity();
        result.setId(request.getId());
        result.setMerk(request.getMerk());
        result.setTipe(request.getTipe());
        result.setTouchbar(request.getTouchbar());
        result.setWarna(request.getWarna());
        result.setLayar(request.getLayar());
        result.setProsesor(request.getProsesor());
        result.setPenyimpanan(request.getPenyimpanan());
        result.setPengisian(request.getPengisian());
        result.setKamera(request.getKamera());
        result.setBatrei(request.getBatrei());
        result.setSistem(request.getSistem());
        result.setHarga(request.getHarga());
        result.setStok(request.getStok());

        try {
            laptopRepo.save(result);
            log.info("Save data laptop to database successfully");
            return result;
        } catch (Exception e){
            log.error("Save data laptop to database failed, error: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public LaptopEntity delete(Integer id) {
        LaptopEntity entity = laptopRepo.findById(id).orElse(null);
        if (entity == null){
            log.info("Data Laptop with id: {} not found", id);
            return null;
        }
        try{
            laptopRepo.delete(entity);
            log.info("Delete data laptop from database successfully");
            return entity;
        } catch (Exception e){
            log.error("Delete data laptop from database failed, error: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public LaptopEntity update(Integer id, LaptopDto request) {
        LaptopEntity entity = laptopRepo.findById(id).orElse(null);
        if (entity == null){
            log.info("Data Laptop with id: {} not found", id);
            return null;
        }
        entity.setId(request.getId());
        entity.setMerk(request.getMerk());
        entity.setTouchbar(request.getTouchbar());
        entity.setWarna(request.getWarna());
        entity.setLayar(request.getLayar());
        entity.setProsesor(request.getProsesor());
        entity.setPenyimpanan(request.getPenyimpanan());
        entity.setPengisian(request.getPengisian());
        entity.setKamera(request.getKamera());
        entity.setBatrei(request.getBatrei());
        entity.setSistem(request.getSistem());
        entity.setHarga(request.getHarga());
        entity.setStok(request.getStok());

        try{
            laptopRepo.save(entity);
            log.info("Update data laptop to database succesfully");
            return entity;
        } catch (Exception e){
            log.error("Update data laptop to databsae failed, error: {}", e.getMessage());
            return null;
        }
    }
}
