package com.siakad.springsiakad.sImpl;

import com.siakad.springsiakad.entity.FakultasEntity;
import com.siakad.springsiakad.model.FakultasModel;
import com.siakad.springsiakad.repository.FakultasRepo;
import com.siakad.springsiakad.service.FakultasService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class FakultasServiceImpl implements FakultasService {
    private final FakultasRepo fakultasRepo;

    @Override
    public List<FakultasModel> getAll() {
        return this.fakultasRepo.findAll().stream().map(FakultasModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<FakultasModel> getById(String id) {
        FakultasEntity result = this.fakultasRepo.findById(id).orElse(null);
        if (result == null){
            return Optional.empty();
        }

        return Optional.of(new FakultasModel(result));
    }

    @Override
    public Optional<FakultasModel> save(FakultasModel request) {
        if (request == null){
            return Optional.empty();
        }

        FakultasEntity entity = new FakultasEntity(request);
        try {
            this.fakultasRepo.save(entity);
            log.info("Save Fakultas to database successfully");
            return Optional.of(new FakultasModel(entity));
        }catch (Exception er){
            log.warn("Save data fakultas failed, error: {}", er.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<FakultasModel> update(FakultasModel request, String id) {
        Optional<FakultasEntity> entity = this.fakultasRepo.findById(id);
        if (entity.isEmpty())
            return Optional.empty();

        FakultasEntity data = entity.get();
        BeanUtils.copyProperties(request, data);
        data.setCreatedAt(LocalDateTime.now());
        data.setCreatedBy("SYSTEM");
        data.setUpdateAt(LocalDateTime.now());
        data.setUpdateBy("SYSTEM");
        try{
            this.fakultasRepo.save(data);
            log.info("Update fakultas to database success");
            return Optional.of(new FakultasModel(data));
        }catch (Exception er){
            log.error("Update fakultas to database failed, error: {}", er.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<FakultasModel> delete(String id) {
        FakultasEntity result = this.fakultasRepo.findById(id).orElse(new FakultasEntity());
        if (result == null){
            log.warn("Fakultas with id: {} not found", id);
            return Optional.empty();
        }

        try {
            this.fakultasRepo.delete(result);
            log.info("Delete data fakultas from database success");
            return Optional.of(new FakultasModel(result));
        }catch (Exception er){
            log.error("Delete data fakultas failed, error: {}", er.getMessage());
            return Optional.empty();
        }
    }
}
