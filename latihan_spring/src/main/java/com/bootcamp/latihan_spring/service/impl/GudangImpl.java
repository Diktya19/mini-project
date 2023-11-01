package com.bootcamp.latihan_spring.service.impl;

import com.bootcamp.latihan_spring.entity.GudangEntity;
import com.bootcamp.latihan_spring.model.GudangDto;
import com.bootcamp.latihan_spring.repository.GudangRepo;
import com.bootcamp.latihan_spring.service.GudangService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class GudangImpl implements GudangService {
    private GudangRepo gudangRepo;
    public GudangImpl(GudangRepo gudangRepo) {
        this.gudangRepo = gudangRepo;
    }

    @Override
    public List<GudangEntity> getAll() {
        return gudangRepo.findAll();
    }

    @Override
    public GudangEntity getById(Integer id) {
        return gudangRepo.findById(id).orElse(new GudangEntity());
    }

    @Override
    public GudangEntity save(GudangDto request) {
        GudangEntity result = new GudangEntity();
        result.setLine(request.getLine());
        result.setRak(request.getRak());
        result.setNamaSpv(request.getNamaSpv());
        result.setNamaBarang(request.getNamaBarang());
        result.setJumlahBarang(request.getJumlahBarang());
        result.setNamaCeking(request.getNamaCeking());
        result.setWaktuCek(request.getWaktuCek());
        result.setShift(request.getShift());
        result.setProduksi(request.getProduksi());

        try{
            gudangRepo.save(result);
            log.info("Save data Gudang to database successfully");
            return result;
        } catch (Exception e){
            log.error("Save data Gudang to database failed, error: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public GudangEntity delete(Integer id) {
        GudangEntity entity = gudangRepo.findById(id).orElse(null);
        if (entity == null){
            log.info("Delete data Gudang from database successfully");
            return null;
        }
        try{
            gudangRepo.delete(entity);
            log.info("Delete data Gudang from database successfully");
            return entity;
        } catch (Exception e){
            log.error("Delete data Gudang form database failed, error: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public GudangEntity update(Integer id, GudangDto request) {
        GudangEntity entity = gudangRepo.findById(id).orElse(null);
        if (entity == null){
            log.info("Data Gudang with id: {} not found", id);
            return null;
        }
        entity.setLine(request.getLine());
        entity.setRak(request.getRak());
        entity.setNamaSpv(request.getNamaSpv());
        entity.setNamaBarang(request.getNamaBarang());
        entity.setJumlahBarang(request.getJumlahBarang());
        entity.setNamaCeking(request.getNamaCeking());
        entity.setWaktuCek(request.getWaktuCek());
        entity.setShift(request.getShift());
        entity.setProduksi(request.getProduksi());

        try{
            gudangRepo.save(entity);
            log.info("Update data Gudang to database successfully");
            return entity;
        } catch (Exception e){
            log.info("Update data Gudang to database failed, error: {}", e.getMessage());
            return null;
        }
    }
}
