package com.siakad.springsiakad.service;

import com.siakad.springsiakad.model.MatakuliahModel;

import java.util.List;
import java.util.Optional;

public interface MatakuliahService {
    List<MatakuliahModel> getAll();
    MatakuliahModel getById(String id);
    Optional<MatakuliahModel> save(MatakuliahModel request);
    Optional<MatakuliahModel> update(MatakuliahModel request, String id);
    Optional<MatakuliahModel> delete(String id);
}
