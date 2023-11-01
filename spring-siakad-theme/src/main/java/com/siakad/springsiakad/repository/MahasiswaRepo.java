package com.siakad.springsiakad.repository;

import com.siakad.springsiakad.entity.MahasiswaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MahasiswaRepo extends JpaRepository<MahasiswaEntity, String> {
}
