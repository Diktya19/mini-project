package com.siakad.springsiakad.sImpl;

import com.siakad.springsiakad.entity.GedungEntity;
import com.siakad.springsiakad.model.GedungModel;
import com.siakad.springsiakad.repository.GedungRepo;
import com.siakad.springsiakad.service.GedungService;
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
public class GedungServiceImpl implements GedungService {
    private final GedungRepo gedungRepo;

    @Override
    public List<GedungModel> getAll() {
        List<GedungEntity> result = this.gedungRepo.findAll();
        if (result.isEmpty()){
            return Collections.emptyList();
        }

        return result.stream().map(GedungModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<GedungModel> getById(String id) {
       GedungEntity result = this.gedungRepo.findById(id).orElse(null);
       if (result == null){
           return Optional.empty();
       }

       return Optional.of(new GedungModel(result));
    }

    @Override
    public Optional<GedungModel> save(GedungModel request) {
        if (request == null){
            return Optional.empty();
        }

        GedungEntity result = new GedungEntity(request);
        try{
            this.gedungRepo.save(result);
            log.info("Save data gedung to database success");
            return Optional.of(new GedungModel(result));
        }catch (Exception er){
            log.warn("Save data gedung failed, error: {}",er.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<GedungModel> update(GedungModel request, String id) {
        GedungEntity entity = this.gedungRepo.findById(id).orElse(null);
        if (entity == null) {
            return Optional.empty();
        }
        BeanUtils.copyProperties(request, entity);
        entity.setId(id);
        try{
            this.gedungRepo.save(entity);
            log.info("Update data gedung to database success");
            return Optional.of(new GedungModel(entity));
        }catch (Exception er){
            log.error("Update data gedung to database failed, error: {}", er.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<GedungModel> delete(String id) {
        GedungEntity entity = this.gedungRepo.findById(id).orElse(null);
        if (entity == null){
            log.warn("gedung with id: {} not found", id);
            return Optional.empty();
        }

        try{
            this.gedungRepo.delete(entity);
            log.info("Delete data gedung from database success");
            return Optional.of(new GedungModel(entity));
        }catch (Exception er){
            log.error("Delete data gedung failed, error: {}", er.getMessage());
            return Optional.empty();
        }
    }
}
