package com.siakad.springsiakad.sImpl;

import com.siakad.springsiakad.entity.MahasiswaEntity;
import com.siakad.springsiakad.model.MahasiswaModel;
import com.siakad.springsiakad.repository.JurusanRepo;
import com.siakad.springsiakad.repository.MahasiswaRepo;
import com.siakad.springsiakad.service.MahasiswaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MahasiswaServiceImpl implements MahasiswaService {
    private final MahasiswaRepo mahasiswaRepo;
    private final JurusanRepo jurusanRepo;

    public MahasiswaServiceImpl(MahasiswaRepo mahasiswaRepo, JurusanRepo jurusanRepo) {
        this.mahasiswaRepo = mahasiswaRepo;
        this.jurusanRepo = jurusanRepo;
    }

    @Override
    public List<MahasiswaModel> getAll() {
        List<MahasiswaEntity> entity = this.mahasiswaRepo.findAll();
        if (entity.isEmpty()){
            return Collections.emptyList();
        }
        return entity.stream().map(MahasiswaModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<MahasiswaModel> getById(String id) {
        MahasiswaEntity entity = this.mahasiswaRepo.findById(id).orElse(null);
        if (entity == null){
            return Optional.empty();
        }

        return Optional.of(new MahasiswaModel(entity));
    }

    @Override
    public Optional<MahasiswaModel> save(MahasiswaModel request) {
        if (request == null){
            return Optional.empty();
        }

        MahasiswaEntity entity = new MahasiswaEntity(request);
        try {
            this.mahasiswaRepo.save(entity);
            log.info("Save Mahasiswa to database success");
            return Optional.of(new MahasiswaModel(entity));
        }catch (Exception er){
            log.error("Save Mahasiswa to database failed, error: {}", er.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<MahasiswaModel> update(MahasiswaModel request, String id) {
        MahasiswaEntity entity = this.mahasiswaRepo.findById(id).orElse(null);
        if (entity == null) {
            return Optional.empty();
        }

        BeanUtils.copyProperties(request, entity);
        entity.setId(id);
        try{
            this.mahasiswaRepo.save(entity);
            log.info("Update mahasiswa to database success");
            return Optional.of(new MahasiswaModel(entity));
        }catch (Exception er){
            log.error("Update mahasiswa to database failed, error: {}", er.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<MahasiswaModel> delete(String id) {
        MahasiswaEntity entity = this.mahasiswaRepo.findById(id).orElse(null);
        if (entity == null){
            log.warn("Mahasiswa with id: {} not found", id);
            return Optional.empty();
        }

        try{
            this.mahasiswaRepo.delete(entity);
            log.info("Delete mahasiswa from database success");
            return Optional.of(new MahasiswaModel(entity));
        }catch (Exception er){
            log.error("Delete mahasiswa from database failed, error: {}", er.getMessage());
            return Optional.empty();
        }
    }
}
