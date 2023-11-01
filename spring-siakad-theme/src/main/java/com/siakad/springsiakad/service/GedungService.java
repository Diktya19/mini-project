package com.siakad.springsiakad.service;

import com.siakad.springsiakad.entity.GedungEntity;
import com.siakad.springsiakad.model.GedungModel;

import java.util.List;
import java.util.Optional;

public interface GedungService {
    List<GedungModel> getAll();
    Optional<GedungModel> getById(String id);
    Optional<GedungModel> save(GedungModel request);
    Optional<GedungModel> update(GedungModel request, String id);
    Optional<GedungModel> delete(String id);
}
