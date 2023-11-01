package com.siakad.springsiakad.sImpl;

import com.siakad.springsiakad.entity.MatakuliahEntity;
import com.siakad.springsiakad.model.MatakuliahModel;
import com.siakad.springsiakad.repository.MatakuliahRepo;
import com.siakad.springsiakad.service.MatakuliahService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MatakuliahServiceImpl implements MatakuliahService {
    private final MatakuliahRepo mataKuliahRepo;

    public MatakuliahServiceImpl(MatakuliahRepo mataKuliahRepo) {
        this.mataKuliahRepo = mataKuliahRepo;
    }

    @Override
    public List<MatakuliahModel> getAll() {
        return this.mataKuliahRepo.findAll().stream().map(MatakuliahModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public MatakuliahModel getById(String id) {
        if (id == null)
            return new MatakuliahModel();

        return this.mataKuliahRepo.findById(id).map(MatakuliahModel::new)
                .orElse(new MatakuliahModel());
    }

    @Override
    public Optional<MatakuliahModel> save(MatakuliahModel request) {
        if (request == null){
            return Optional.empty();
        }

        MatakuliahEntity result = new MatakuliahEntity(request);
        try{
            this.mataKuliahRepo.save(result);
            log.info("Save matakuliah to database successfully");
            return Optional.of(new MatakuliahModel(result));
        }catch (Exception er){
            log.error("Save matakuliah to database failed, error: {}", er.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<MatakuliahModel> update(MatakuliahModel request, String id) {
        Optional<MatakuliahEntity> entity = this.mataKuliahRepo.findById(id);
        if (entity.isEmpty())
            return Optional.empty();

        MatakuliahEntity data = entity.get();
        BeanUtils.copyProperties(request, data);
        data.setCreatedAt(LocalDateTime.now());
        data.setCreatedBy("SYSTEM");
        data.setUpdateAt(LocalDateTime.now());
        data.setUpdateBy("SYSTEM");

        try{
            this.mataKuliahRepo.save(data);
            log.info("Update matakuliah to database success");
            return Optional.of(new MatakuliahModel());
        }catch (Exception er){
            log.error("Update matakuliah to database failed, error: {}", er.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<MatakuliahModel> delete(String id) {
        MatakuliahEntity result = this.mataKuliahRepo.findById(id).orElse(new MatakuliahEntity());
        if (result == null){
            log.warn("Matakuliah with id: {} not found", id);
            return Optional.empty();
        }

        try{
            this.mataKuliahRepo.delete(result);
            log.info("Delete matakuliah from database success");
            return Optional.of(new MatakuliahModel(result));
        }catch (Exception er){
            log.error("Delete matakuliah from database failed, error: {}", er.getMessage());
            return Optional.empty();
        }
    }
}
