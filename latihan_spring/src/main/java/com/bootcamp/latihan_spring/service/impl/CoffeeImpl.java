package com.bootcamp.latihan_spring.service.impl;

import com.bootcamp.latihan_spring.entity.CoffeeEntity;
import com.bootcamp.latihan_spring.model.CoffeeDto;
import com.bootcamp.latihan_spring.repository.CoffeeRepo;
import com.bootcamp.latihan_spring.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CoffeeImpl implements CoffeeService {
    private CoffeeRepo coffeeRepo;

    public CoffeeImpl(CoffeeRepo coffeeRepo) {
        this.coffeeRepo = coffeeRepo;
    }

    @Override
    public List<CoffeeEntity> getAll() {
        return coffeeRepo.findAll();
    }

    @Override
    public CoffeeEntity getByid(Integer id) {
        return coffeeRepo.findById(id).orElse(new CoffeeEntity());
    }

    @Override
    public CoffeeEntity save(CoffeeDto request) {
        CoffeeEntity result = new CoffeeEntity();
        result.setId(request.getId());
        result.setMerk(request.getMerk());
        result.setJenisKopi(request.getJenisKopi());
        result.setAsalDaerah(request.getAsalDaerah());
        result.setProduksi(request.getProduksi());
        result.setBerat(request.getBerat());
        result.setHarga(request.getHarga());
        result.setJumlah(request.getJumlah());
        result.setKadaluarsa(request.getKadaluarsa());

        try {
            coffeeRepo.save(result);
            log.info("Save data Coffee to database successfully");
            return result;
        } catch (Exception e){
            log.error("Save data Coffe to database failed, error: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public CoffeeEntity delete(Integer id) {
        CoffeeEntity entity = coffeeRepo.findById(id).orElse(null);
        if (entity == null){
            log.info("Data Coffee with id: {} not found", id);
            return null;
        }
        try{
            coffeeRepo.delete(entity);
            log.info("Delete data Coffee from database successfully");
            return entity;
        } catch (Exception e){
            log.error("Delete data Coffee from database failed, error: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public CoffeeEntity update(Integer id, CoffeeDto request) {
        CoffeeEntity entity = coffeeRepo.findById(id).orElse(null);
        if (entity == null){
            log.info("Data Coffee with id: {} not found", id);
            return null;
        }
        entity.setId(request.getId());
        entity.setMerk(request.getMerk());
        entity.setJenisKopi(request.getJenisKopi());
        entity.setAsalDaerah(request.getAsalDaerah());
        entity.setProduksi(request.getProduksi());
        entity.setBerat(request.getBerat());
        entity.setHarga(request.getHarga());
        entity.setJumlah(request.getJumlah());
        entity.setKadaluarsa(request.getKadaluarsa());

        try{
            coffeeRepo.save(entity);
            log.info("Update data Coffee to database successfully");
            return entity;
        } catch (Exception e){
            log.error("Update data Coffee to database failed, error: {}", e.getMessage());
            return null;
        }
    }


}