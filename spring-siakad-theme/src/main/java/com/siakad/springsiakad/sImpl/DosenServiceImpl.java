package com.siakad.springsiakad.sImpl;

import com.siakad.springsiakad.entity.DosenEntity;
import com.siakad.springsiakad.model.DosenModel;
import com.siakad.springsiakad.repository.DosenRepo;
import com.siakad.springsiakad.service.DosenService;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class DosenServiceImpl implements DosenService {
    private final DosenRepo dosenRepo;

    @Override
    public List<DosenModel> getAll() {
       List<DosenEntity> result = this.dosenRepo.findAll();
       if (result == null){
           return Collections.emptyList();
       }
       return result.stream().map(DosenModel::new)
               .collect(Collectors.toList());
    }

    @Override
    public Optional<DosenModel> getById(String id) {
       DosenEntity result = this.dosenRepo.findById(id).orElse(null);
       if (result == null){
           return Optional.empty();
       }

       return Optional.of(new DosenModel(result));
    }

    @Override
    public Optional<DosenModel> save(DosenModel request) {
        if (request == null){
            return Optional.empty();
        }

        DosenEntity result = new DosenEntity(request);
        try{
            this.dosenRepo.save(result);
            log.info("Save data dosen to database success");
            return Optional.of(new DosenModel(result));
        }catch (Exception er){
            log.warn("Save data dosen failed, error: {}",er.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<DosenModel> update(DosenModel request, String id) {
        DosenEntity entity = this.dosenRepo.findById(id).orElse(null);
        if (entity == null) {
            return Optional.empty();
        }

        BeanUtils.copyProperties(request, entity);
        entity.setId(id);

        try{
            this.dosenRepo.save(entity);
            log.info("Update data dosen to database success");
            return Optional.of(new DosenModel(entity));
        }catch (Exception er){
            log.error("Update data dosen to database failed, error: {}", er.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<DosenModel> delete(String id) {
        DosenEntity entity = this.dosenRepo.findById(id).orElse(null);
        if (entity == null){
            log.warn("Dosen with id: {} not found", id);
            return Optional.empty();
        }
        try{
            this.dosenRepo.delete(entity);
            log.info("Delete data dosen from database success");
            return Optional.of(new DosenModel(entity));
        }catch (Exception er){
            log.error("Delete data dosen failed, error: {}", er.getMessage());
            return Optional.empty();
        }
    }
}
