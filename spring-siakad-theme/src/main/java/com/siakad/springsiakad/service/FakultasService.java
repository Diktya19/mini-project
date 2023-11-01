package com.siakad.springsiakad.service;

import com.siakad.springsiakad.model.FakultasModel;

import java.util.List;
import java.util.Optional;

public interface FakultasService {
    List<FakultasModel> getAll();
    Optional<FakultasModel> getById(String id);
    Optional<FakultasModel> save(FakultasModel request);
    Optional<FakultasModel> update(FakultasModel request, String id);
    Optional<FakultasModel> delete(String id);
}
