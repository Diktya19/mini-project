package com.siakad.springsiakad.sImpl;

import com.siakad.springsiakad.entity.FakultasEntity;
import com.siakad.springsiakad.entity.JurusanEntity;
import com.siakad.springsiakad.model.JurusanModel;
import com.siakad.springsiakad.repository.FakultasRepo;
import com.siakad.springsiakad.repository.JurusanRepo;
import com.siakad.springsiakad.service.JurusanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class JurusanServiceImpl implements JurusanService {
    private final JurusanRepo jurusanRepo;
    private final FakultasRepo fakultasRepo;

    public JurusanServiceImpl(JurusanRepo jurusanRepo, FakultasRepo fakultasRepo) {
        this.jurusanRepo = jurusanRepo;
        this.fakultasRepo = fakultasRepo;
    }

    @Override
    public List<JurusanModel> getAll() {
        return this.jurusanRepo.findAll().stream().map(JurusanModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<JurusanModel> getById(String id) {
       JurusanEntity result = this.jurusanRepo.findById(id).orElse(null);
       if (result == null){
           return Optional.empty();
       }

       return Optional.of(new JurusanModel(result));
    }

    @Override
    public Optional<JurusanModel> save(JurusanModel request) {
        if (request == null){
            return Optional.empty();
        }

        JurusanEntity result = new JurusanEntity(request);
        try{
            this.jurusanRepo.save(result);
            log.info("Save data jurusan to database success");
            return Optional.of(new JurusanModel(result));
        }catch (Exception er){
            log.error("Save data jurusan to database failed, error: {}", er.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<JurusanModel> update(JurusanModel request, String id) {
        Optional<JurusanEntity> entity = this.jurusanRepo.findById(id);
        if (entity.isEmpty())
            return Optional.empty();

        JurusanEntity data = entity.get();
        BeanUtils.copyProperties(request, data);
        try{
            this.jurusanRepo.save(data);
            log.info("Update jurusan to database success");
            return Optional.of(new JurusanModel(data));
        }catch (Exception er){
            log.error("Update jurusan failed, error: {}", er.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<JurusanModel> delete(String id) {
        JurusanEntity entity = this.jurusanRepo.findById(id).orElse(null);
        if (entity == null){
            log.warn("Jurusan with id: {} not found", id);
            return Optional.empty();
        }

        try{
            this.jurusanRepo.delete(entity);
            log.info("Delete jurusan from database success");
            return Optional.of(new JurusanModel(entity));
        }catch (Exception er){
            log.error("Delete jurusan from database failed, error: {}", er.getMessage());
            return Optional.empty();
        }
    }
}
