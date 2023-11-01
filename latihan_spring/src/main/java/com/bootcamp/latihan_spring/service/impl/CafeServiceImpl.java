package com.bootcamp.latihan_spring.service.impl;

import com.bootcamp.latihan_spring.entity.CafeEntity;
import com.bootcamp.latihan_spring.model.CafetariaDto;
import com.bootcamp.latihan_spring.repository.CafeRepo;
import com.bootcamp.latihan_spring.service.CafeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CafeServiceImpl implements CafeService {

    private CafeRepo cafeRepo;
    public CafeServiceImpl(CafeRepo cafeRepo) {
        this.cafeRepo = cafeRepo;
    }

    @Override
    public List<CafeEntity> getAll() {
        return cafeRepo.findAll();
    }

    @Override
    public CafeEntity getById(Integer id) {
        return cafeRepo.findById(id).orElse(new CafeEntity());
    }

    @Override
    public CafeEntity save(CafetariaDto request) {
        CafeEntity result = new CafeEntity();
        result.setId(request.getId());
        result.setName(request.getName());
        result.setDescription(request.getDescription());
        result.setPrice(request.getPrice());
        result.setQuantity(request.getQuantity());

        try{
            cafeRepo.save(result);
            log.info("Save data Cafetaria to database successfully");
            return result;
        } catch (Exception e){
            log.error("Save data Cafetaria to database failed, error: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public CafeEntity delete(Integer id) {
        CafeEntity entity = cafeRepo.findById(id).orElse(null);
        if (entity == null){
            log.info("Data Cafetaria with id: {} not found", id);
            return null;
        }
        try{
            cafeRepo.delete(entity);
            log.info("Delete data Cafetaria from database succesfully");
            return entity;
        } catch (Exception e){
            log.error("Delete data Cafetaria from database failed, error: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public CafeEntity update(Integer id, CafetariaDto request) {
        CafeEntity entity = cafeRepo.findById(id).orElse(null);
        if (entity == null){
            log.info("Data Cafetaria with id: {} not found", id);
            return null;
        }
        entity.setId(request.getId());
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setPrice(request.getPrice());
        entity.setQuantity(request.getQuantity());

        try{
            cafeRepo.save(entity);
            log.info("Update data Cafetaria to database successfully");
            return entity;
        } catch (Exception e){
            log.error("Upadate data Cafetaria to database failed, error: {}", e.getMessage());
            return null;
        }
    }
}
