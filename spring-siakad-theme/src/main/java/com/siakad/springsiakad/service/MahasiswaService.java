package com.siakad.springsiakad.service;

import com.siakad.springsiakad.entity.DosenEntity;
import com.siakad.springsiakad.entity.MahasiswaEntity;
import com.siakad.springsiakad.model.DosenModel;
import com.siakad.springsiakad.model.MahasiswaModel;

import java.util.List;
import java.util.Optional;

public interface MahasiswaService {
    List<MahasiswaModel> getAll();
    Optional<MahasiswaModel> getById(String id);
    Optional<MahasiswaModel> save(MahasiswaModel request);
    Optional<MahasiswaModel> update(MahasiswaModel request, String id);
    Optional<MahasiswaModel> delete(String id);
}
