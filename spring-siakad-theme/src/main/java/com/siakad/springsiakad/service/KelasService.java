package com.siakad.springsiakad.service;

import com.siakad.springsiakad.entity.KelasEntity;
import com.siakad.springsiakad.model.KelasModel;

import java.util.List;
import java.util.Optional;

public interface KelasService {
    List<KelasModel> getAll();
    Optional<KelasModel> getById(String id);
    Optional<KelasModel> save(KelasModel request);
    Optional<KelasModel> update(KelasModel request, String id);
    Optional<KelasModel> delete(String id);
}
