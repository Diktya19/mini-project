package com.siakad.springsiakad.repository;

import com.siakad.springsiakad.entity.MatakuliahEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatakuliahRepo extends JpaRepository<MatakuliahEntity, String> {
}
