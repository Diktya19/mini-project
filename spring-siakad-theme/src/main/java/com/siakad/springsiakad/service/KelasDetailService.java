package com.siakad.springsiakad.service;

import com.siakad.springsiakad.model.KelasDetailModel;

import java.util.List;
import java.util.Optional;

public interface KelasDetailService {
    List<KelasDetailModel> getAll();
    KelasDetailModel getById(String id);
    Optional<KelasDetailModel> save(KelasDetailModel request);
    Optional<KelasDetailModel> update(KelasDetailModel request, String id);
    Optional<KelasDetailModel> delete(String id);
}
