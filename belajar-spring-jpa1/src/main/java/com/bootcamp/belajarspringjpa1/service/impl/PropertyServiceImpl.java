package com.bootcamp.belajarspringjpa1.service.impl;

import com.bootcamp.belajarspringjpa1.entity.PropertyEntity;
import com.bootcamp.belajarspringjpa1.model.PropertyDto;
import com.bootcamp.belajarspringjpa1.repository.PropertyRepo;
import com.bootcamp.belajarspringjpa1.service.PropertyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PropertyServiceImpl implements PropertyService {

    private PropertyRepo propertyRepo;

    public PropertyServiceImpl(PropertyRepo propertyRepo) {
        this.propertyRepo = propertyRepo;
    }

    @Override
    public List<PropertyEntity> getAll() {
        return propertyRepo.findAll();
    }

    @Override
    public PropertyEntity getById(Integer id) {
        return propertyRepo.findById(id).orElse(new PropertyEntity());
    }

    @Override
    public PropertyEntity save(PropertyDto request) {

        PropertyEntity result = new PropertyEntity();
        result.setId(request.getId());
        result.setPenanggungJawab(request.getPenanggungJawab());
        result.setNamaProperty(request.getNamaProperty());
        result.setBerdiriDari(request.getBerdiriDari());
        result.setDeskripsi(request.getDeskripsi());
        result.setWarna(request.getWarna());
        result.setAlamat(request.getAlamat());
        result.setTerisi(request.getTerisi());
        result.setKosong(request.getKosong());
        result.setKondisiTempat(request.getKondisiTempat());
        result.setProblem(request.getProblem());

        try{
            propertyRepo.save(result);
            log.info("Save data Property to database successfully");
            return result;
        } catch (Exception e){
            log.error("Save data property to database failed, error: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public PropertyEntity delete(Integer id) {
        PropertyEntity entity = propertyRepo.findById(id).orElse(null);
        if (entity == null) {
            log.info("Data Property with id: {} not found", id);
            return null;
        }

        try{
            propertyRepo.delete(entity);
            log.info("Delete data Property from database successfully");
            return entity;
        } catch (Exception e){
            log.error("Delete data Property from database failed, error: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public PropertyEntity update(Integer id, PropertyDto request) {

        PropertyEntity entity = propertyRepo.findById(id).orElse(null);
        if (entity == null){
            log.info("Data Property with id: {} not found", id);
            return null;
        }
        entity.setId(request.getId());
        entity.setPenanggungJawab(request.getPenanggungJawab());
        entity.setNamaProperty(request.getNamaProperty());
        entity.setBerdiriDari(request.getBerdiriDari());
        entity.setDeskripsi(request.getDeskripsi());
        entity.setWarna(request.getWarna());
        entity.setAlamat(request.getAlamat());
        entity.setTerisi(request.getTerisi());
        entity.setKosong(request.getKosong());
        entity.setKondisiTempat(request.getKondisiTempat());
        entity.setProblem(request.getProblem());

        try{
            propertyRepo.save(entity);
            log.info("Update data Property to database succesfully");
            return entity;
        } catch (Exception e){
            log.error("Update data property to database failed, error: {}", e.getMessage());
            return null;
        }
    }
}
