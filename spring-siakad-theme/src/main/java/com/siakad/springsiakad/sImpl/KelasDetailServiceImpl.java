package com.siakad.springsiakad.sImpl;

import com.siakad.springsiakad.entity.KelasDetailEntity;
import com.siakad.springsiakad.model.KelasDetailModel;
import com.siakad.springsiakad.repository.KelasDetailRepo;
import com.siakad.springsiakad.service.KelasDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class KelasDetailServiceImpl implements KelasDetailService {
    private final KelasDetailRepo kelasDetailRepo;

    @Override
    public List<KelasDetailModel> getAll() {
        return kelasDetailRepo.findAll()
                .stream()
                .map(KelasDetailModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public KelasDetailModel getById(String id) {
       return kelasDetailRepo.findById(id)
               .map(KelasDetailModel::new)
               .orElse(null);
    }

    @Override
    public Optional<KelasDetailModel> save(KelasDetailModel request) {
        if (request == null){
            return Optional.empty();
        }

        KelasDetailEntity result = new KelasDetailEntity(request);
        try{
            this.kelasDetailRepo.save(result);
            log.info("Save data kelasDetail to database success");
            return Optional.of(new KelasDetailModel(result));
        }catch (Exception er){
            log.warn("Save data kelasDetail failed, error: {}",er.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<KelasDetailModel> update(KelasDetailModel request, String id) {
       KelasDetailEntity entity = kelasDetailRepo.findById(id).orElse(null);
           if (entity == null){
               return Optional.empty();
           }
           BeanUtils.copyProperties(request, entity);
           try{
               kelasDetailRepo.save(entity);
               log.info("Update kelas detail success");
               return Optional.of(new KelasDetailModel());
           }catch (Exception er){
               log.error("Update kelas detail failed, error : {}", er.getMessage());
               return Optional.empty();
        }
    }

    @Override
    public Optional<KelasDetailModel> delete(String id) {
        KelasDetailEntity result = this.kelasDetailRepo.findById(id).orElse(null);
        if (result == null) {
            return Optional.empty();
        }

        try {
            kelasDetailRepo.delete(result);
            this.kelasDetailRepo.delete(result);
            log.info("delete kelasDetail success");
            return Optional.of(new KelasDetailModel(result));
        } catch (Exception er) {
            log.error("delete kelasDetail failed, error: {}", er.getMessage());
            return Optional.empty();
        }
    }
}
