package com.siakad.springsiakad.service;

import com.siakad.springsiakad.model.DosenModel;

import java.util.List;
import java.util.Optional;

public interface DosenService {
    List<DosenModel> getAll();
    Optional<DosenModel> getById(String id);
    Optional<DosenModel> save(DosenModel request);
    Optional<DosenModel> update(DosenModel request, String id);
    Optional<DosenModel> delete(String id);
}
