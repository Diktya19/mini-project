package com.siakad.springsiakad.service;


import com.siakad.springsiakad.entity.RuanganEntity;
import com.siakad.springsiakad.model.RuanganModel;

import java.util.List;
import java.util.Optional;

public interface RuanganService {
    List<RuanganModel> getAll();
    Optional<RuanganModel> getById(String id);
    Optional<RuanganModel> save(RuanganModel request);
    Optional<RuanganModel> update(RuanganModel request, String id);
    Optional<RuanganModel> delete(String id);
}
