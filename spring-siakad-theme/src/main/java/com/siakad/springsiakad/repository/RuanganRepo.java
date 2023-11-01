package com.siakad.springsiakad.repository;

import com.siakad.springsiakad.entity.RuanganEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuanganRepo extends JpaRepository<RuanganEntity, String> {
}
