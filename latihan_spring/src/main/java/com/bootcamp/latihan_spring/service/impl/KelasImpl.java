package com.bootcamp.latihan_spring.service.impl;

import com.bootcamp.latihan_spring.entity.KelasEntity;
import com.bootcamp.latihan_spring.model.KelasDto;
import com.bootcamp.latihan_spring.repository.KelasRepo;
import com.bootcamp.latihan_spring.service.KelasService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j

public class KelasImpl implements KelasService {
    private KelasRepo kelasRepo;

    public KelasImpl(KelasRepo kelasRepo) {
        this.kelasRepo = kelasRepo;
    }

    @Override
    public List<KelasEntity> getAll() {
        return kelasRepo.findAll();
    }

    @Override
    public KelasEntity getById(Integer id) {
        return kelasRepo.findById(id).orElse(new KelasEntity());
    }

    @Override
    public KelasEntity save(KelasDto request) {
        KelasEntity result = new KelasEntity();

        result.setId(request.getId());
        result.setNamaKelas(request.getNamaKelas());
        result.setWaliKelas(request.getWaliKelas());
        result.setJurusan(request.getJurusan());
        result.setKetuaMurid(request.getKetuaMurid());
        result.setJumlahMurid(request.getJumlahMurid());
        result.setPria(request.getPria());
        result.setPermpuan(request.getPermpuan());
        result.setMeja(request.getMeja());
        result.setKursi(request.getKursi());

        try {
            kelasRepo.save(result);
            log.info("Save data Kelas to database successfully");
            return result;
        } catch (Exception e) {
            log.error("Save data Kelas to database failed, error: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public KelasEntity delete(Integer id) {
        KelasEntity entity = kelasRepo.findById(id).orElse(null);
        if (entity == null) {
            log.info("Data Kelas with id: {} not found", id);
            return null;
        }
        try {
            kelasRepo.delete(entity);
            log.info("Delete data Kelas from database successfully");
            return entity;
        } catch (Exception e) {
            log.error("Delete data Kelas form database failed, error: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public KelasEntity update(Integer id, KelasDto request) {
        KelasEntity entity = kelasRepo.findById(id).orElse(null);
        if (entity == null) {
            log.info("Data Kelas with id: {} not found", id);
            return null;
        }
        entity.setId(request.getId());
        entity.setNamaKelas(request.getNamaKelas());
        entity.setWaliKelas(request.getWaliKelas());
        entity.setJurusan(request.getJurusan());
        entity.setKetuaMurid(request.getKetuaMurid());
        entity.setJumlahMurid(request.getJumlahMurid());
        entity.setPria(request.getPria());
        entity.setPermpuan(request.getPermpuan());
        entity.setMeja(request.getMeja());
        entity.setKursi(request.getKursi());

        try {
            kelasRepo.save(entity);
            log.info("Update data kelas to database successfully");
            return entity;
        } catch (Exception e) {
            log.error("Update data kelas to database failed, error: {}", e.getMessage());
            return null;
        }
    }
}
