package com.bootcamp.springmvc.service.Impl;

import com.bootcamp.springmvc.repository.MobilRepo;
import com.bootcamp.springmvc.entity.MobilEntity;
import com.bootcamp.springmvc.model.MobilDto;
import com.bootcamp.springmvc.service.MobilService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MobilServiceImpl implements MobilService {

    private final MobilRepo repo;

    public MobilServiceImpl(MobilRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<MobilEntity> getAll() {
        return this.repo.findAll();
    }

    @Override
    public MobilEntity getById(Integer id) {
        return this.repo.findById(id).orElse(null);
    }

    @Override
    public MobilEntity save(MobilDto request) {
        MobilEntity result = new MobilEntity();
        BeanUtils.copyProperties(request, result);

        try{
            this.repo.save(result);
            log.info("Save data Mobil to database successfully");
            return result;
        }catch (Exception er){
            log.error("Save data Mobil to database failed, error: {}", er.getMessage());
            return null;
        }
    }

    @Override
    public MobilEntity update(Integer id, MobilDto request) {
        MobilEntity entity = this.repo.findById(id).orElse(null);
        if (entity == null){
            log.warn("Data Mobil with id: {} not found", id);
            return null;
        }
        BeanUtils.copyProperties(request, entity);
        try{
            this.repo.save(entity);
            log.info("Update data Mobil to database succesfully");
            return entity;
        } catch (Exception ex){
            log.error("Update data Mobil to database failed, error: {}", ex.getMessage());
            return null;
        }
    }

    @Override
    public MobilEntity delete(Integer id) {
        MobilEntity result = this.repo.findById(id).orElse(null);
        if (result == null){
            log.warn("Delete data Mobil with id: {} not found", id);
            return null;
        }
        try{
            this.repo.delete(result);
            log.info("Delete data Mobil from database succesfully");
            return result;
        } catch (Exception ex){
            log.error("Delete data Mobil from database failed, error: {}", ex.getMessage());
            return null;
        }
    }
}
