package com.siakad.springsiakad.sImpl;

import com.siakad.springsiakad.entity.KelasEntity;
import com.siakad.springsiakad.model.KelasModel;
import com.siakad.springsiakad.repository.KelasRepo;
import com.siakad.springsiakad.service.KelasService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class KelasServiceImpl implements KelasService {
    private final KelasRepo kelasRepo;

    @Override
    public List<KelasModel> getAll() {
        List<KelasEntity> result = this.kelasRepo.findAll();
        if (result.isEmpty()){
            return Collections.emptyList();
        }

        return result.stream().map(KelasModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<KelasModel> getById(String id) {
        KelasEntity result = this.kelasRepo.findById(id).orElse(null);
        if (result == null){
            return Optional.empty();
        }

        return Optional.of(new KelasModel(result));
    }

    @Override
    public Optional<KelasModel> save(KelasModel request) {
        if (request == null){
            return Optional.empty();
        }

        KelasEntity result = new KelasEntity(request);
        try{
            this.kelasRepo.save(result);
            log.info("Save data kelas to database success");
            return Optional.of(new KelasModel(result));
        }catch (Exception er){
            log.warn("Save data kelas failed, error: {}",er.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<KelasModel> update(KelasModel request, String id) {
        KelasEntity entity = this.kelasRepo.findById(id).orElse(null);
        if (entity == null) {
            return Optional.empty();
        }
        BeanUtils.copyProperties(request, entity);
        entity.setId(id);

        try{
            this.kelasRepo.save(entity);
            log.info("Update data kelas to database success");
            return Optional.of(new KelasModel(entity));
        }catch (Exception er){
            log.error("Update data kelas to database failed, error: {}", er.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<KelasModel> delete(String id) {
        KelasEntity entity = this.kelasRepo.findById(id).orElse(null);
        if (entity == null){
            log.warn("kelas with id: {} not found", id);
            return Optional.empty();
        }

        try{
            this.kelasRepo.delete(entity);
            log.info("Delete data kelas from database success");
            return Optional.of(new KelasModel(entity));
        }catch (Exception er){
            log.error("Delete data kelas failed, error: {}", er.getMessage());
            return Optional.empty();
        }
    }
}
