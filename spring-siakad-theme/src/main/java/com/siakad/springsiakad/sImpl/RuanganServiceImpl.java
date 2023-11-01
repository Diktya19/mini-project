package com.siakad.springsiakad.sImpl;

import com.siakad.springsiakad.entity.RuanganEntity;
import com.siakad.springsiakad.model.RuanganModel;
import com.siakad.springsiakad.repository.RuanganRepo;
import com.siakad.springsiakad.service.RuanganService;
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
public class RuanganServiceImpl implements RuanganService {
    private final RuanganRepo ruanganRepo;

    @Override
    public List<RuanganModel> getAll() {
        List<RuanganEntity> result = this.ruanganRepo.findAll();
        if (result.isEmpty()){
            return Collections.emptyList();
        }

        return result.stream().map(RuanganModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<RuanganModel> getById(String id) {
        RuanganEntity result = this.ruanganRepo.findById(id).orElse(null);
        if (result == null){
            return Optional.empty();
        }

        return Optional.of(new RuanganModel(result));
    }

    @Override
    public Optional<RuanganModel> save(RuanganModel request) {
        if (request == null){
            return Optional.empty();
        }

        RuanganEntity result = new RuanganEntity(request);
        try{
            this.ruanganRepo.save(result);
            log.info("Save data ruangan to database success");
            return Optional.of(new RuanganModel(result));
        }catch (Exception er){
            log.warn("Save data ruangan failed, error: {}",er.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<RuanganModel> update(RuanganModel request, String id) {
        RuanganEntity entity = this.ruanganRepo.findById(id).orElse(null);
        if (entity == null) {
            return Optional.empty();
        }

        BeanUtils.copyProperties(request, entity);
        entity.setId(id);

        try{
            this.ruanganRepo.save(entity);
            log.info("Update data ruangan to database success");
            return Optional.of(new RuanganModel(entity));
        }catch (Exception er){
            log.error("Update data ruangan to database failed, error: {}", er.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<RuanganModel> delete(String id) {
        RuanganEntity entity = this.ruanganRepo.findById(id).orElse(null);
        if (entity == null){
            log.warn("ruangan with id: {} not found", id);
            return Optional.empty();
        }
        try{
            this.ruanganRepo.delete(entity);
            log.info("Delete data ruangan from database success");
            return Optional.of(new RuanganModel(entity));
        }catch (Exception er){
            log.error("Delete data ruangan failed, error: {}", er.getMessage());
            return Optional.empty();
        }
    }
}
